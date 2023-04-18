package org.apache.practise.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFromStreamP {
  private Queue<Integer> maxQueue;
  private Queue<Integer> minQueue;

  public MedianFromStreamP() {
    this.maxQueue = new PriorityQueue<>();
    this.minQueue = new PriorityQueue<>();
  }

  public void addData(int data) {
    this.maxQueue.add(data);
    if(maxQueue.size()>minQueue.size()) {
      minQueue.add(maxQueue.poll());
    } else {
      final Integer poll = maxQueue.poll();
      final Integer poll1 = minQueue.poll();
      minQueue.add(poll);
      maxQueue.add(poll1);
    }
  }

  public double getMedian() {
    if(maxQueue.size()==minQueue.size()) {
      return (maxQueue.peek()+minQueue.peek())/2.0;
    } else {
      return minQueue.peek();
    }
  }
}
