package org.apache.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayE12 {
  public static void main(String[] args) {
    int k = 5;
    int[] a = { 3, 1, 6, 2, 10, 4 };
    Queue<Integer> queue = new PriorityQueue(2);
    for (int i = 0; i < a.length; i++) {
      queue.add(a[i]);
    }
    for (int i = 0; i < k - 1; i++) {
      queue.poll();
    }
    System.out.println(queue.poll());
  }
}
