package org.apache.cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
  // store keys of cache
  private Deque<Integer> dq;
  private HashSet<Integer> map;
  private int size;
  public LRUCache(int size) {
    this.dq = new LinkedList<>();
    this.map = new HashSet<>();
    this.size = size;
  }

  public void refer(Integer data) {
    if(!map.contains(data)) {
      if(dq.size() == size) {
        final Integer integer = dq.removeLast();
        map.remove(integer);
      }
    } else {
      dq.remove(data);
    }
    dq.push(data);
    map.add(data);
  }

  public static void main(String[] args)
  {
    LRUCache ca = new LRUCache(4);
    ca.refer(1);
    ca.refer(2);
    ca.refer(3);
    ca.refer(1);
    ca.display();
    ca.refer(4);
    ca.display();
    ca.refer(5);
    ca.display();
  }
  public void display()
  {
    Iterator<Integer> itr = dq.iterator();
    while (itr.hasNext()) {
      System.out.print(itr.next() + " ");
    }
    System.out.println();
  }
}
