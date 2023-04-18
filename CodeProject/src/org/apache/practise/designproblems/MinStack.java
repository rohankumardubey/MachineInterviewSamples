package org.apache.practise.designproblems;

import java.util.LinkedList;
import java.util.TreeMap;

public class MinStack {
  private LinkedList<Integer> linkedList;
  private TreeMap<Integer, Integer> keyToFrequencyMap;

  public MinStack() {
    this.linkedList = new LinkedList<>();
    this.keyToFrequencyMap = new TreeMap<>();
  }
  public void push(int data) {
    this.linkedList.addLast(data);
    int frequency = keyToFrequencyMap.getOrDefault(data, 0) + 1;
    keyToFrequencyMap.put(data, frequency);
  }

  public int pop() {
    Integer integer = this.linkedList.removeLast();
    Integer integer1 = keyToFrequencyMap.remove(integer);
    if(integer1>1) {
      keyToFrequencyMap.put(integer, --integer1);
    }
    return integer;
  }

  public int min() {
    return keyToFrequencyMap.firstKey();
  }
}
