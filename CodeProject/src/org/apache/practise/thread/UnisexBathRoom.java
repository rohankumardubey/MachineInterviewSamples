package org.apache.practise.thread;

import java.util.concurrent.Semaphore;

public class UnisexBathRoom {
  private String isUsedBy;
  private static final String MAN = "man";
  private static final String WOMEN = "woman";
  private static final String NONE = "none";
  private Semaphore semaphore;
  private int currentUsed;

  public UnisexBathRoom(int maxSlot) {
    this.isUsedBy = NONE;
    this.semaphore = new Semaphore(maxSlot);
  }

  public void maleUseBathroom(String name) throws InterruptedException {
    synchronized (this) {
      if (isUsedBy.equals(WOMEN)) {
        wait();
      }
      this.semaphore.acquire();
      currentUsed++;
      isUsedBy = MAN;
    }
    usingBathRoom(name);
    semaphore.release();
    synchronized (this) {
      currentUsed--;
      if (currentUsed == 0) {
        isUsedBy = NONE;
      }
      notifyAll();
    }
  }

  public void femaleUseBathroom(String name) throws InterruptedException {
    synchronized (this) {
      if (isUsedBy.equals(MAN)) {
        wait();
      }
      this.semaphore.acquire();
      currentUsed++;
      isUsedBy = WOMEN;
    }
    usingBathRoom(name);
    semaphore.release();
    synchronized (this) {
      currentUsed--;
      if (currentUsed == 0) {
        isUsedBy = NONE;
      }
      notifyAll();
    }
  }
  void usingBathRoom(String name) throws InterruptedException {
    System.out.println("Used By" + name);
    Thread.sleep(10000);
    System.out.println("Done using bathroom" + name);
  }
}
