package org.apache.practise.designproblems;

import org.apache.practise.designproblems.MinMaxBasedQueue;

public class MinMaxBasedQueueTest {
  public static void main(String[] args) {
    MinMaxBasedQueue minMaxBasedQueue = new MinMaxBasedQueue();
    minMaxBasedQueue.add(5);
    minMaxBasedQueue.add(-1);
    minMaxBasedQueue.add(1);
    minMaxBasedQueue.add(2);
    minMaxBasedQueue.add(3);
    System.out.println(minMaxBasedQueue.getMax());
    System.out.println(minMaxBasedQueue.getMin());
    minMaxBasedQueue.remove();
    System.out.println(minMaxBasedQueue.getMax());
    System.out.println(minMaxBasedQueue.getMin());
    minMaxBasedQueue.remove();
    System.out.println(minMaxBasedQueue.getMax());
    System.out.println(minMaxBasedQueue.getMin());
  }
}
