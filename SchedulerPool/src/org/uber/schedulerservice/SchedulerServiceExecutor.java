package org.uber.schedulerservice;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class SchedulerServiceExecutor implements SchedulerService {
  private ThreadPool threadPool;
  private PriorityQueue<Task> queue;
  private TaskSubmitter taskSubmitter;

  public SchedulerServiceExecutor(int poolSize) {
    this.threadPool = new ThreadPool(poolSize);
    this.taskSubmitter = new TaskSubmitter();
    this.taskSubmitter.start();
    this.queue = new PriorityQueue<>();
  }

  @Override public void submit(Runnable task) {
    this.threadPool.submit(task);
  }

  @Override public void submit(Runnable task, long delay, TimeUnit timeUnit) {
    queue.add(new Task(task, delay, 1, timeUnit));
  }

  @Override public void submit(Runnable task, long delay, long repetation, TimeUnit timeUnit) {
    queue.add(new Task(task, delay, repetation, timeUnit));
  }

  @Override public void shutdown() {
    this.threadPool.shutDown();
    this.taskSubmitter.interrupt();
  }

  private class Task implements Comparable<Task> {
    private Runnable task;
    private long delay;
    private long repetation;
    private TimeUnit timeUnit;
    private long currentTime;
    private long currentRepatationNumber;

    private Task(Runnable task, long delay, long repetation, TimeUnit timeUnit) {
      this.task = task;
      this.delay = delay;
      this.repetation = repetation;
      this.timeUnit = timeUnit;
      this.currentTime = System.currentTimeMillis();
    }

    private void incrementRepetataionCount() {
      currentRepatationNumber++;
    }

    private Runnable getTask() {
      currentTime = System.currentTimeMillis();
      incrementRepetataionCount();
      return task;
    }

    private long getDelay() {
      long gap = System.currentTimeMillis() - currentTime / 1000;
      if (gap > delay) {
        return 0;
      } else {
        return delay -= gap;
      }
    }

    private boolean canSubmit() {
      return getDelay() <= 0 && !isRepetationOver();
    }

    private boolean isRepetationOver() {
      return currentRepatationNumber > repetation;
    }

    @Override public int compareTo(Task o) {
      long timeOne = getDelay();
      long timeTwo = o.getDelay();
      if (timeOne > timeTwo) {
        return 1;
      } else if (timeOne < timeTwo) {
        return -1;
      }
      return 0;
    }
  }

  private class TaskSubmitter extends Thread {
    @Override public void run() {
      while (!queue.isEmpty()) {
        final Task poll = queue.poll();
        if(poll==null) {
          continue;
        }
        if (poll.canSubmit()) {
          threadPool.submit(poll.getTask());
          if (!poll.isRepetationOver()) {
            queue.add(poll);
          }
        } else {
          queue.add(poll);
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
