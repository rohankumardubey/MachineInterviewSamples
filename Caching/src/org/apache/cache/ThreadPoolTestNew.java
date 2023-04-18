package org.apache.cache;

public class ThreadPoolTestNew {
  public static void main(String[] args) {
    ThreadPoolNew pool = new ThreadPoolNew(5);
    pool.submit(new A(1));
    pool.shutDown();
  }

  private static class A implements Runnable {
    private int a;
    public A(int a) {
      this.a = a;
    }
    @Override public void run() {
      System.out.println(a);
    }
  }
}
