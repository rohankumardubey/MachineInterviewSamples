package org.apache.cache;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolNew {
  private boolean isShutdown;
  private BlockingQueue<Runnable> queue;
  private int poolSize;
  private Worker[] workers;
  public ThreadPoolNew(int poolSize) {
    this.poolSize = poolSize;
    this.queue = new LinkedBlockingQueue<>();
    this.workers = new Worker[poolSize];
    for (int i = 0; i < poolSize; i++) {
      this.workers[i] = new Worker();
      this.workers[i].start();

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
    while(!queue.isEmpty()) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    isShutdown = true;
    for (int i = 0; i < poolSize; i++) {
      this.workers[i].interrupt();
    }
  }


  private class Worker extends Thread {
    @Override public void run() {
      while(!isShutdown) {
        Runnable take = null;
        try {
          take = queue.take();
          take.run();
        } catch (InterruptedException e) {
        }
      }
    }
  }
}

