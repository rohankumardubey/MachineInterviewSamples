package org.apache.practise.codeproblems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KLargest {
  public static void main(String[] args) {
    Queue<Integer> queue = new PriorityQueue<>();
    int a[]= {3,2,1,5,6,4};
    for (int i = 0; i <a.length ; i++) {
      queue.add(a[i]);
      if(queue.size()>2) {
        System.out.println("polling: " + queue.poll());
      }
    }
    System.out.println(queue.poll());
  }
}
