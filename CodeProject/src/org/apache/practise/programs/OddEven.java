package org.apache.practise.programs;

public class OddEven {
  public static void main(String[] args) {
    Counter c = new Counter();
    OddThread t1= new OddThread(c, 10000);
    EvenThread t2= new EvenThread(c, 10000);
    t1.start();
    t2.start();
  }

  private static class OddThread extends Thread {
    private final Counter counter;
    private int max;

    private OddThread(Counter counter, int max) {
      this.counter = counter;
      this.max = max;
    }

    public void run() {
      while (counter.num < max) {
        synchronized (counter) {
          if (counter.num % 2 == 0) {
            try {
              counter.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
//          System.out.println("OddThread:" + counter.num);
          if(counter.num%2==0) {
            System.out.println("Invalid print");
          }
          counter.num++;
          counter.notify();
        }
      }
    }
  }

  private static class EvenThread extends Thread {
    private final Counter counter;
    private int max;

    private EvenThread(Counter counter, int max) {
      this.counter = counter;
      this.max = max;
    }

    public void run() {
      while (counter.num < max) {
        synchronized (counter) {
          if (counter.num % 2 != 0) {
            try {
              counter.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
//          System.out.println("EvenThread:" + counter.num);
          if(counter.num%2!=0) {
            System.out.println("Invalid print");
          }
          counter.num++;
          counter.notify();
        }
      }
    }
  }

  private static class Counter {
    private int num = 1;
  }
}
