package org.coding.schedulerservice;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SchedulerService {
  private DelayQueue<TaskWrapper> queue;
  private ExecutorService internalExecutors;
  private Thread internalWorker;
  private boolean isShutdown;

  public SchedulerService(int numberofThreads) {
    internalExecutors = Executors.newFixedThreadPool(numberofThreads);
    this.queue = new DelayQueue<>();
    this.internalWorker = new InternalWorker();
    this.internalWorker.start();
  }

  public void schedule(Runnable runnable) {
    queue.add(new TaskWrapper(runnable, 0, 1, TimeUnit.MILLISECONDS, 0, false));
  }

  public void schedule(Runnable runnable, long delay, TimeUnit timeUnit) {
    queue.add(new TaskWrapper(runnable, delay, 1, timeUnit, delay, false));
  }

  public void schedule(Runnable runnable, long delay, int repetation, TimeUnit timeUnit) {
    queue.add(new TaskWrapper(runnable, delay, repetation, timeUnit, delay, false));
  }

  public void schedule(Runnable runnable, Date date) {
    queue.add(new TaskWrapper(runnable, System.currentTimeMillis() - date.getTime(), 1,
        TimeUnit.MILLISECONDS, 0, false));
  }

  public void schedule(Runnable runnable, Date date, int repetation) {
    queue.add(new TaskWrapper(runnable, System.currentTimeMillis() - date.getTime(), repetation,
        TimeUnit.HOURS, 24, false));
  }

  public void scheduleAtFixDelay(Runnable runnable, long delay, long period, TimeUnit timeUnit) {
    queue.add(new TaskWrapper(runnable, delay, 1, TimeUnit.MILLISECONDS, period, true));
  }

  private class TaskWrapper implements Delayed {
    private Runnable task;
    private long initialDelay;
    private int repetation;
    private TimeUnit timeUnit;
    private long actualDelay;
    private boolean fixedTask;
    private long taskAddedTime;
    private int counter;

    private TaskWrapper(Runnable task, long initialDelay, int repetation, TimeUnit timeUnit,
        long actualDelay, boolean fixedTask) {
      this.task = task;
      this.initialDelay = initialDelay;
      this.repetation = repetation;
      this.timeUnit = timeUnit;
      this.fixedTask = fixedTask;
      this.taskAddedTime = System.currentTimeMillis();
      switch (timeUnit) {
        case DAYS:
          this.initialDelay = initialDelay * 24 * 60 * 60 * 1000;
          this.actualDelay = actualDelay* 24 * 60 * 60 * 1000;
          break;
        case HOURS:
          this.initialDelay = initialDelay * 60 * 60 * 1000;
          this.actualDelay = actualDelay* 60 * 60 * 1000;
          break;
        case MINUTES:
          this.initialDelay = initialDelay * 60 * 1000;
          this.actualDelay = actualDelay* 60 * 1000;
          break;
        case SECONDS:
          this.initialDelay = initialDelay * 1000;
          this.actualDelay = actualDelay*  1000;
          break;
        case MILLISECONDS:
          this.initialDelay = initialDelay;
          this.actualDelay = actualDelay;
      }
    }

    private boolean isFixedTask() {
      return fixedTask;
    }

    private boolean isRepetationOver() {
      return this.counter >= repetation;
    }

    @Override public long getDelay(TimeUnit unit) {
      long currentGap = initialDelay- (System.currentTimeMillis() - (taskAddedTime));
      return currentGap <= 0 ? 0 : currentGap * 1000000;
    }

    @Override public int compareTo(Delayed o) {
      long firstDelay = o.getDelay(TimeUnit.NANOSECONDS);
      long secondDelay = o.getDelay(TimeUnit.NANOSECONDS);
      if (firstDelay > secondDelay) {
        return 1;
      } else if (firstDelay < secondDelay) {
        return -1;
      }
      return 0;
    }

    private Runnable getTask() {
      this.counter++;
      return this.task;
    }

    private void updateTaskAddedTime() {
      initialDelay = actualDelay;
      this.taskAddedTime = System.currentTimeMillis();
    }
  }

  private class InternalWorker extends Thread {
    public void run() {
      while (!isShutdown) {
        TaskWrapper poll = null;
        try {
          poll = queue.take();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if (null != poll) {
          internalExecutors.submit(poll.getTask());
          if (!poll.isRepetationOver() || poll.isFixedTask()) {
            poll.updateTaskAddedTime();
            queue.add(poll);
          }
        }
      }
    }
  }

}
