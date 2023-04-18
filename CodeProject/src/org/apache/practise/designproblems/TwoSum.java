package org.apache.practise.designproblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TwoSum {
  private Map<Integer,Integer> dataToFrequncyMap;
  public TwoSum() {
    this.dataToFrequncyMap = new HashMap<>();
  }

  public void add(int data) {
    int frequency = dataToFrequncyMap.getOrDefault(data, 0) + 1;
    dataToFrequncyMap.put(data, frequency);
  }

  public boolean find(int value) {
    if (dataToFrequncyMap.isEmpty()) {
      return false;
    }
    final Iterator<Map.Entry<Integer, Integer>> iterator = dataToFrequncyMap.entrySet().iterator();
    while(iterator.hasNext()) {
      final Integer key = iterator.next().getKey();
      final Integer frequency = dataToFrequncyMap.get(value - key);
      if(null!=frequency && frequency>0) {
        return true;
      }
    }
    return false;
  }
}
