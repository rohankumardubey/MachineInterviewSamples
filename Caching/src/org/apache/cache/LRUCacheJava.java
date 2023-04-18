package org.apache.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheJava implements Cache<String,Integer> {
  private Map<String, Integer> lruCacheMap;
  public LRUCacheJava( final int cacheSize) {
    this.lruCacheMap = new LinkedHashMap<String, Integer>(cacheSize, 1.0f, true){
      @Override
      protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > cacheSize;
      }
    };
  }

  public void put(String key, Integer value) {
    lruCacheMap.put(key, value);
  }

  public Integer get(String key) {
    return lruCacheMap.get(key);
  }

  public void print() {
    System.out.println(lruCacheMap);
  }
}
