package org.apache.practise.designproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import org.apache.practise.cache.Cache;

public class LRUDynamic implements Cache<Integer, Integer> {
  private Map<Integer, Integer> cache;
  private Map<Integer, Cacheable> keyToTimeMap;
  private int cacheSize;
  private TreeMap<Cacheable, Integer> treeMap;

  public LRUDynamic(int cacheSize) {
    this.cacheSize = cacheSize;
    this.cache = new HashMap<>();
    this.treeMap = new TreeMap<>();
    this.keyToTimeMap = new HashMap<>();
  }

  @Override public void put(Integer key, Integer value) {
    if (null == cache.get(key)) {
      if (cache.size() == cacheSize) {
        final Cacheable cacheable = treeMap.lastKey();
        final Integer remove = treeMap.remove(cacheable);
        cache.remove(remove);
        keyToTimeMap.remove(remove);
      }
    } else {
      final Cacheable remove = keyToTimeMap.remove(key);
      treeMap.remove(remove);
    }
    cache.put(key, value);
    Cacheable cacheable = new Cacheable(System.currentTimeMillis());
    treeMap.put(cacheable, key);
    keyToTimeMap.put(key, cacheable);
  }

  @Override public Integer get(Integer key) {
    final Integer integer = cache.get(key);
    if (null == integer) {
      return null;
    }
    Cacheable removed = keyToTimeMap.get(key);
    treeMap.remove(removed);
    Cacheable cacheable = new Cacheable(System.currentTimeMillis());
    treeMap.put(cacheable, key);
    keyToTimeMap.put(key, cacheable);
    return integer;
  }

  private class Cacheable implements Comparable<Cacheable> {
    private long timeStamp;

    private Cacheable(long timeStamp) {
      this.timeStamp = timeStamp;
    }

    @Override public int compareTo(Cacheable o) {
      long gap1 = System.currentTimeMillis() - timeStamp;
      long gap2 = System.currentTimeMillis() - o.timeStamp;
      if (gap1 > gap2) {
        return 1;
      } else if (gap2 > gap1) {
        return -1;
      }
      return 0;
    }
  }
}
