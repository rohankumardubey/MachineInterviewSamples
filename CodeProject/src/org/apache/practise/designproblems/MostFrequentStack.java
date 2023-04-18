package org.apache.practise.designproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MostFrequentStack {
  private Map<Integer, Stack<Integer>> frequencyToKeyMap;
  private Map<Integer, Integer> keyToFrequencyMap;
  private int maxFrequency;

  public MostFrequentStack() {
    this.frequencyToKeyMap = new HashMap<>();
    this.keyToFrequencyMap = new HashMap<>();
  }

  public void push(int data) {
    final int frequency = keyToFrequencyMap.getOrDefault(data, 0) + 1;
    keyToFrequencyMap.put(data, frequency);
    if (frequency > maxFrequency) {
      maxFrequency = frequency;
    }
    Stack<Integer> orDefault = frequencyToKeyMap.getOrDefault(frequency, new Stack<>());
    orDefault.push(data);
    frequencyToKeyMap.put(frequency, orDefault);
  }

  public int pop() {
    Integer mostFrequentKey = frequencyToKeyMap.get(maxFrequency).pop();
    Integer frequency = keyToFrequencyMap.get(mostFrequentKey);
    if (frequency - 1 > 0) {
      keyToFrequencyMap.put(mostFrequentKey, frequency - 1);
    }
    if (frequencyToKeyMap.get(frequency).size() == 0) {
      maxFrequency = frequency - 1;
      frequencyToKeyMap.remove(frequency);
    }
    return mostFrequentKey;
  }
}
