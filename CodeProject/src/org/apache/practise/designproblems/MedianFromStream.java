package org.apache.practise.designproblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFromStream {
  private Queue<Integer> maxHeap;
  private Queue<Integer> minHeap;

  public MedianFromStream() {
    this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    this.minHeap = new PriorityQueue<>();
  }

  public void addNumber(int data) {
    maxHeap.add(data);
    if (maxHeap.size() > minHeap.size()) {
      minHeap.add(maxHeap.poll());
    } else if (maxHeap.peek() > minHeap.peek()) {
      int n1 = maxHeap.poll();
      int n2 = minHeap.poll();
      minHeap.add(n1);
      maxHeap.add(n2);
    }
  }

  public double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    } else {
      return minHeap.peek();
    }
  }
}
