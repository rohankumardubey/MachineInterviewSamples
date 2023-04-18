package org.apache.practise.thread;

public class ReadWriteLock {
  private int reader;
  private boolean isWriteLock;
  public synchronized void acquireReadLock() throws InterruptedException {
    while (isWriteLock) {
      wait();
    }
    reader++;
    notify();
  }
  public synchronized void acquireWriteLock() throws InterruptedException {
    while (isWriteLock || reader != 0) {
      wait();
    }
    isWriteLock = true;
    notify();
  }
  public synchronized void releaseReadLock() {
    reader--;
    notify();
  }
  public synchronized void releaseWriteLock() {
    isWriteLock = false;
    notify();
  }
}
