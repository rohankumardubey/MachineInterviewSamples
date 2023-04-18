package org.apache.cache;

public class ThreadPoolTest {
  public static void main(String[] args) {
    ThreadPool pool = new ThreadPool(5);
    pool.execute(new A(1));
    pool.shutdown();
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
