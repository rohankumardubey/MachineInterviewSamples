package org.apache.practise.designproblems;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
  private Queue<Integer> queue;

  public HitCounter() {
    this.queue = new LinkedList<>();
  }

  public void hit(int timestamp) {
    while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
      queue.poll();
    }
    this.queue.add(timestamp);
  }

  public int getHits(int timestamp) {
    while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
      queue.poll();
    }
    return queue.size();
  }
}
