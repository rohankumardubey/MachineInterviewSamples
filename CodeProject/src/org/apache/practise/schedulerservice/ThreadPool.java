package org.apache.practise.schedulerservice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
  private BlockingQueue<Runnable> queue;
  private int poolSize;
  private Worker[] workers;
  private boolean isShutdown;
  public ThreadPool(int poolSize) {
    this.workers = new Worker[poolSize];
    this.queue = new LinkedBlockingQueue<>(poolSize);
    this.poolSize = poolSize;
    for (int i = 0; i < poolSize; i++) {
      this.workers[i] = new Worker();
      this.workers[i].start();
    }
  }

  public void submit(Runnable task) {
    try {
      queue.put(task);
    } catch (InterruptedException e) {
    }
  }

  public void shutdown() {
    while(!queue.isEmpty()) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
    }
    isShutdown = true;
    for (int i = 0; i < poolSize; i++) {
      this.workers[i].interrupt();
    }
  }

  private class Worker extends Thread {
    public void run() {
      while(!isShutdown) {
        try {
          final Runnable take = queue.take();
          take.run();
        } catch (InterruptedException e) {
        }

      }
    }
  }
}
