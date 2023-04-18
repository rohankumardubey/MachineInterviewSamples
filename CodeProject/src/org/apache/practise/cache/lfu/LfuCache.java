package org.apache.practise.cache.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.practise.cache.Cache;

public class LfuCache implements Cache<Integer, Integer> {

  private int cacheSize;
  private Map<Integer, Integer> keyToFrequencyMap;
  private Map<Integer, Integer> cache;
  private Map<Integer, Set<Integer>> frequencyToKeysMap;
  private int currentMin;

  public LfuCache(int cacheSize) {
    this.cacheSize = cacheSize;
    this.cache = new HashMap<>();
    this.keyToFrequencyMap = new HashMap<>();
    this.frequencyToKeysMap = new HashMap<>();
    this.frequencyToKeysMap.put(1, new LinkedHashSet<>());
    currentMin = -1;
  }

  @Override public void put(Integer key, Integer value) {
    if (cache.get(key) != null) {
      cache.put(key, value);
      get(key);
      return;
    }
    if (cache.size() == cacheSize) {
      final Integer minFrequencyKey = frequencyToKeysMap.get(currentMin).iterator().next();
      frequencyToKeysMap.get(currentMin).remove(minFrequencyKey);
      cache.remove(minFrequencyKey);
      keyToFrequencyMap.remove(minFrequencyKey);
    }
    currentMin = 1;
    cache.put(key, value);
    keyToFrequencyMap.put(key, currentMin);
    frequencyToKeysMap.get(currentMin).add(key);
  }

  @Override public Integer get(Integer key) {
    final Integer value = cache.get(key);
    if (null == value) {
      return null;
    }
    final Integer frequency = keyToFrequencyMap.get(key);
    int newFrequency = frequency + 1;
    keyToFrequencyMap.put(key, newFrequency);
    frequencyToKeysMap.get(frequency).remove(key);
    // below code is required for removal
    if (frequency == currentMin && frequencyToKeysMap.get(frequency).size() == 0) {
      currentMin++;
    }
    if (frequencyToKeysMap.get(newFrequency) == null) {
      frequencyToKeysMap.put(newFrequency, new LinkedHashSet<>());
    }
    frequencyToKeysMap.get(newFrequency).add(key);
    return value;
  }
}
