package org.apache.practise.cache.mfu;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.practise.cache.Cache;

public class MfuCache implements Cache<Integer, Integer> {
  private int cacheSize;
  private Map<Integer, Integer> cache;
  private Map<Integer, Integer> keyToFrequencyMap;
  private Map<Integer, Set<Integer>> frequencyToKeyListMap;
  private int currentMax;

  public MfuCache(int cacheSize) {
    this.cacheSize = cacheSize;
    this.cache = new HashMap<>();
    this.keyToFrequencyMap = new HashMap<>();
    this.frequencyToKeyListMap = new HashMap<>();
    this.frequencyToKeyListMap.put(1, new LinkedHashSet<>());
    this.currentMax = 1;
  }

  @Override public void put(Integer key, Integer value) {
    final Integer currentValue = cache.get(key);
    if (null != currentValue) {
      get(key);
      return;
    }
    if (cache.size() == cacheSize) {
      final Integer maxFrequencyKey = frequencyToKeyListMap.get(currentMax).iterator().next();
      frequencyToKeyListMap.get(currentMax).remove(maxFrequencyKey);
      if (frequencyToKeyListMap.get(currentMax).size() == 0) {
        frequencyToKeyListMap.remove(currentMax);
        for (int i = currentMax - 1; i > 0; i--) {
          if (frequencyToKeyListMap.get(i).size() > 0) {
            currentMax = i;
            break;
          }
        }
      }
      cache.remove(maxFrequencyKey);
      keyToFrequencyMap.remove(maxFrequencyKey);
    }
    cache.put(key, value);
    frequencyToKeyListMap.get(1).add(key);
    keyToFrequencyMap.put(key, 1);
  }

  @Override public Integer get(Integer key) {
    final Integer value = cache.get(key);
    if (null == value) {
      return null;
    }
    final Integer frequency = keyToFrequencyMap.get(key);
    int newFrequency = frequency + 1;
    keyToFrequencyMap.put(key, newFrequency);
    frequencyToKeyListMap.get(frequency).remove(key);
    if (frequencyToKeyListMap.get(newFrequency) == null) {
      frequencyToKeyListMap.put(newFrequency, new LinkedHashSet<>());
      currentMax = newFrequency;
    }
    frequencyToKeyListMap.get(newFrequency).add(key);
    return value;
  }
}
