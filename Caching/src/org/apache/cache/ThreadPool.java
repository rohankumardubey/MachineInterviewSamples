package org.apache.cache;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
  private int poolSize;
  private final PoolWorker[] threads;
  private final LinkedBlockingQueue<Runnable> queue;

  public ThreadPool(int poolSize) {
    this.poolSize = poolSize;
    threads =  new PoolWorker[poolSize];
    this.poolSize = poolSize;
    queue = new LinkedBlockingQueue();
    for (int i = 0; i < poolSize; i++) {
      threads[i] = new PoolWorker(i);
      threads[i].start();
    }
  }

  public void execute(Runnable task) {
    synchronized (queue) {
      queue.add(task);
      queue.notify();
    }
  }

  public void shutdown() {
    for (int i = 0; i < poolSize; i++) {
      threads[i].isShutdown = true;
    }
    for (int i = 0; i < poolSize; i++) {
      threads[i].interrupt();
    }
  }
  private class PoolWorker extends Thread {
    private int id;
    boolean isShutdown=false;
    public PoolWorker(int id) {
      this.id = id;
    }
    public void run() {
      Runnable task = null;
      boolean isBreak = false;
      while (isShutdown) {
        synchronized (queue) {
          while (queue.isEmpty()) {
            try {
              queue.wait();
              System.out.println("I am here: " + id);
            } catch (InterruptedException e) {
              isBreak = true;
              break;
            }
          }
          if(isBreak) {
            break;
          }
          if(!queue.isEmpty()) {
            task = queue.poll();
          }
        }
        try {
          if (null != task) {
            task.run();
          }
        } catch (RuntimeException e) {
          System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
        }
      }
      System.out.println("I am out:" + id);
    }
  }
}
