package org.apache.practise.cache.mru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.practise.cache.Cache;

public class MruCache implements Cache<Integer, Integer> {

  private int cacheSize;
  private Map<Integer, Integer> cache;
  private Deque<Integer> deque;

  public MruCache(int cacheSize) {
    this.cacheSize = cacheSize;
    this.cache = new HashMap<>();
    this.deque = new LinkedList<>();
  }

  @Override public void put(Integer key, Integer value) {
    if(null==cache.get(key)) {
      if(cache.size()==cacheSize) {
        final Integer removedKey = deque.removeFirst();
        cache.remove(removedKey);
      } else {
        deque.remove(key);
      }
    }
    cache.put(key, value);
    deque.addFirst(key);
  }

  @Override public Integer get(Integer key) {
    final Integer value = cache.get(key);
    if(null== value) {
      return null;
    }
    deque.remove(key);
    deque.addFirst(key);
    return value;
  }
}
