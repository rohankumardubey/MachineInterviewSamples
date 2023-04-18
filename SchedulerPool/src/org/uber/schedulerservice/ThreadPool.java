package org.uber.schedulerservice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
  private int poolSize;
  private BlockingQueue<Runnable> queue;
  private boolean isShutdown;
  private ThreadPoolWorker[] tWorker;

  public ThreadPool(int poolSize) {
    this.poolSize = poolSize;
    this.queue = new LinkedBlockingQueue<>();
    this.tWorker = new ThreadPoolWorker[poolSize];
    for (int i = 0; i < tWorker.length; i++) {
      tWorker[i] = new ThreadPoolWorker();
      tWorker[i].start();
    }
  }

  public void submit(Runnable task) {
    try {
      queue.put(task);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void shutDown() {
    while (!this.queue.isEmpty()) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    isShutdown = true;
    for (int i = 0; i < tWorker.length; i++) {
      tWorker[i].interrupt();
    }
  }

  private class ThreadPoolWorker extends Thread {
    @Override public void run() {
      while (!isShutdown) {
        try {
          final Runnable take = queue.take();
          take.run();
        } catch (InterruptedException e) {
        }
      }
    }
  }
}
