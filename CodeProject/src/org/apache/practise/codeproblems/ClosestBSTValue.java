package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.practise.designproblems.BSTNode;

public class ClosestBSTValue {

  public List<Integer> closesKValues(BSTNode node, double target, int k) {
    List<Integer> list = new ArrayList<>();
    if(node==null) {
      return list;
    }
    Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override public int compare(Integer o1, Integer o2) {
        return Double.compare(Math.abs(o1-target), Math.abs(o2-target));
      }
    });
    inOrder(node, k, queue);
    while(!queue.isEmpty()){
      list.add(queue.poll());
    }
    return list;
  }

  private void inOrder(BSTNode root, int k, Queue<Integer> queue) {
    if(null==root) {
      return;
    }
    queue.add(root.getData());
    if(queue.size()>k) {
      queue.poll();
    }
    inOrder(root.getLeft(), k, queue);
    inOrder(root.getRight(), k, queue);
  }
}
