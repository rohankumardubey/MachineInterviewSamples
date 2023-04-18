package org.apache.practise.designproblems;

import java.util.Map;
import java.util.Stack;

public class MostFrequentStackOne {
  private Map<Integer, Integer> keyToFrequencyMap;
  private Map<Integer, Stack<Integer>> frequencyToKeyMap;
  private int maxFrequency;

  public void push(int key) {
    int currentFrequency = keyToFrequencyMap.getOrDefault(key, 0);
    int newFrequency = currentFrequency+1;
    if(newFrequency > maxFrequency) {
      maxFrequency = newFrequency ;
    }
    keyToFrequencyMap.put(key, newFrequency);
    final Stack<Integer> orDefault =
        frequencyToKeyMap.getOrDefault(currentFrequency, new Stack<>());
    orDefault.push(key);
  }

  public int pop() {
    final Integer pop = frequencyToKeyMap.get(maxFrequency).pop();
    if(null!=pop) {
      final Integer integer = keyToFrequencyMap.get(pop);
      if(integer-1 > 0) {
        keyToFrequencyMap.put(pop, integer-1);
      }
      if(frequencyToKeyMap.get(maxFrequency).size()==0) {
        maxFrequency = integer-1;
        frequencyToKeyMap.remove(integer);
      }
      return pop;
    }
    return -1;
  }
}
