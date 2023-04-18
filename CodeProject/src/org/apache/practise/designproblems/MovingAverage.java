package org.apache.practise.designproblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {
  private int windowSize;
  private double currentSum;
  private Queue<Integer> queue;

  public MovingAverage(int windowSize) {
    this.windowSize = windowSize;
    this.queue = new ArrayDeque<>();
  }

  public double next(int data) {
    if (queue.size() < windowSize) {
      queue.add(data);
      currentSum += data;
      return currentSum / queue.size();
    } else {
      currentSum -= queue.poll();
      queue.add(data);
      currentSum += data;
      return currentSum / queue.size();
    }
  }
}
