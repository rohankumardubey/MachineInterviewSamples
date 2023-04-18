package org.apache.practise.designproblems;

public class MovingAverageTest {
  public static void main(String[] args) {
    MovingAverage movingAverage = new MovingAverage(3);
    System.out.println(movingAverage.next(1));
    System.out.println(movingAverage.next(2));
    System.out.println(movingAverage.next(3));
    System.out.println(movingAverage.next(4));
    System.out.println(movingAverage.next(10));
  }
}
