package org.apache.practise.thread;

public class CountingSemaphore {
  private int maxCount;
  private int usedPermits;
  public CountingSemaphore(int maxCount) {
    this.maxCount = maxCount;
  }

  public synchronized void acquire() throws InterruptedException {
    if(usedPermits == maxCount) {
      wait();
    }
    usedPermits++;
    notify();
  }

  public synchronized void release() throws InterruptedException {
    if(usedPermits==0) {
      wait();
    }
    usedPermits--;
    notify();
  }

}
