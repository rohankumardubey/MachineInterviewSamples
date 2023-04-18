package org.apache.practise.schedulerservice;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SchedulerServiceExecutor implements SchedulerService {

  private ThreadPool pool;

  private final BlockingQueue<SchedulerTask> queue;

  private InternalWorker internalWorker;

  private boolean isShutdown;

  public SchedulerServiceExecutor(int numberOfThreds) {
    this.pool = new ThreadPool(numberOfThreds);
    this.internalWorker = new InternalWorker();
    this.queue = new PriorityBlockingQueue<>();
    this.internalWorker.start();
  }

  @Override public void schedule(Runnable runnable) {
    addTask(new SchedulerTask(runnable, 0, 1, TimeUnit.MILLISECONDS, 0, false));
  }

  private void addTask(SchedulerTask schedulerTask) {
    synchronized (queue) {
      this.queue.add(schedulerTask);
      queue.notifyAll();
    }
  }

  private void validateTime(TimeUnit timeUnit) {
    switch (timeUnit) {
      case MICROSECONDS:
      case NANOSECONDS:
        throw new RuntimeException("Invalid time unit type");
    }
  }

  @Override public void schedule(Runnable runnable, long delay, TimeUnit timeUnit) {
    validateTime(timeUnit);
    addTask(new SchedulerTask(runnable, delay, 1, timeUnit, delay, false));
  }

  @Override public void schedule(Runnable runnable, long delay, int repetation, TimeUnit timeUnit) {
    validateTime(timeUnit);
    addTask(new SchedulerTask(runnable, delay, repetation, timeUnit, delay, false));
  }

  @Override public void schedule(Runnable runnable, Date date) {
    addTask(new SchedulerTask(runnable, System.currentTimeMillis() - date.getTime(), 1,
        TimeUnit.MILLISECONDS, 0, false));
  }

  @Override public void schedule(Runnable runnable, Date date, int repetation) {
    addTask(new SchedulerTask(runnable, System.currentTimeMillis() - date.getTime(), repetation,
        TimeUnit.MILLISECONDS, 24 * 60 * 60 * 1000, false));
  }

  @Override
  public void scheduleAtFixDelay(Runnable runnable, long delay, long period, TimeUnit timeUnit) {
    addTask(new SchedulerTask(runnable, delay, 1, TimeUnit.MILLISECONDS, period, true));
  }

  private class InternalWorker extends Thread {
    public void run() {
      while (!isShutdown) {
        final SchedulerTask poll = queue.poll();
        if (poll == null || !poll.canExecute()) {
          synchronized (queue) {
            try {
              if (poll != null) {
                queue.add(poll);
                queue.wait(poll.getDelay());
              } else {
                queue.wait();
              }
            } catch (InterruptedException e) {
            }
          }
        } else {
          pool.submit(poll.getTask());
          if (!poll.isRepetationOver() || poll.isFixedTask()) {
            poll.updateTaskAddedTime();
            queue.add(poll);
          }
        }
      }
    }
  }

  private class SchedulerTask implements Comparable<SchedulerTask> {
    private Runnable task;

    private long initalDelay;

    private int repetation;

    private long taskAddedTime;

    private int counter;

    private long actualDelay;

    private boolean isFixedTask;

    private SchedulerTask(Runnable task, long initalDelay, int repetation, TimeUnit timeUnit,
        long actualDelay, boolean isFixedTask) {
      this.task = task;
      this.repetation = repetation;
      this.taskAddedTime = System.currentTimeMillis();
      this.actualDelay = actualDelay;
      this.isFixedTask = isFixedTask;
      switch (timeUnit) {
        case DAYS:
          this.initalDelay = initalDelay * 24 * 60 * 60 * 1000;
          break;
        case HOURS:
          this.initalDelay = initalDelay * 60 * 60 * 1000;
          break;
        case MINUTES:
          this.initalDelay = initalDelay * 60 * 1000;
          break;
        case SECONDS:
          this.initalDelay = initalDelay * 1000;
          break;
        case MILLISECONDS:
          this.initalDelay = initalDelay;
      }
    }

    private boolean canExecute() {
      return System.currentTimeMillis() - taskAddedTime >= initalDelay;
    }

    private Runnable getTask() {
      this.counter++;
      return this.task;
    }

    private void updateTaskAddedTime() {
      initalDelay = actualDelay;
      this.taskAddedTime = System.currentTimeMillis();
    }

    private long getDelay() {
      long currentGap = System.currentTimeMillis() - taskAddedTime;
      return currentGap >= initalDelay ? 1 : currentGap;
    }

    private boolean isFixedTask() {
      return isFixedTask;
    }

    private boolean isRepetationOver() {
      return this.counter >= repetation;
    }

    @Override public int compareTo(SchedulerTask o) {
      long firstDelay = getDelay();
      long secondDelay = o.getDelay();
      if (firstDelay > secondDelay) {
        return 1;
      } else if (firstDelay < secondDelay) {
        return -1;
      }
      return 0;
    }
  }

  @Override public void shutDown() {
    this.pool.shutdown();
    isShutdown = true;
    this.internalWorker.interrupt();
  }
}
