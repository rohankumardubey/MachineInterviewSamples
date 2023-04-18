package org.apache.practise.designproblems;

import java.util.LinkedList;
import java.util.TreeMap;

public class MaxStack {
  private LinkedList<Integer> linkedList;
  private TreeMap<Integer,Integer> treeMap;
  public MaxStack() {
    this.linkedList = new LinkedList<>();
    this.treeMap = new TreeMap<>();
  }

  public void push(int data) {
    this.linkedList.addLast(data);
    Integer integer = this.treeMap.get(data);
    if(null==integer) {
      integer=0;
    }
    this.treeMap.put(data, ++integer);
  }

  public Integer pop() {
    final Integer integer = this.linkedList.removeFirst();
    Integer frequency = this.treeMap.get(integer);
    --frequency;
    if(frequency > 0) {
      this.treeMap.put(integer, frequency);
    }
    return integer;
  }

  public Integer top() {
    return this.linkedList.getFirst();
  }

  public Integer peekMax() {
    return treeMap.lastKey();
  }

  public Integer popMax() {
    Integer max = treeMap.lastKey();
    Integer integer = treeMap.remove(max);
    integer--;
    if(integer>0) {
      treeMap.put(max, integer);
    }
    linkedList.removeFirstOccurrence(max);
    return max;
  }
}
