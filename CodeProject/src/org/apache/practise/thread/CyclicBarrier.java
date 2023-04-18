package org.apache.practise.thread;

public class CyclicBarrier {
  private int numberOfThreads;
  private int counter;
  public CyclicBarrier(int numberOfThreads) {
    this.numberOfThreads = numberOfThreads;
  }

  public synchronized void await() throws InterruptedException {
    counter++;
    if(counter== numberOfThreads) {
     notifyAll();
     counter=0;
    } else {
      wait();
    }
  }
}
