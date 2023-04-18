package org.apache.practise.designproblems;

import java.util.LinkedList;
import java.util.TreeMap;

public class MinMaxBasedQueue {

  private LinkedList<Integer> linkedList;
  private TreeMap<Integer, Integer> map;

  public MinMaxBasedQueue() {
    linkedList = new LinkedList<>();
    map = new TreeMap<>();
  }

  public void add(int data) {
    linkedList.addLast(data);
    Integer integer = map.get(data);
    if (null == integer) {
      integer = 0;
    }
    map.put(data, ++integer);
  }

  public void remove() {
    Integer integer = linkedList.removeFirst();
    Integer remove = map.remove(integer);
    --remove;
    if (remove > 0) {
      map.put(integer, remove);
    }
  }

  public int getMin() {
    return map.firstKey();
  }

  public int getMax() {
    return map.lastKey();
  }
}
