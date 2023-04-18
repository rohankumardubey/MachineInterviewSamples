package org.apache.practise.cache.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.practise.cache.Cache;

public class LruCache implements Cache<Integer, Integer> {

  private int cacheSize;

  private Map<Integer, Integer> cache;

  private Deque<Integer> queue;

  public LruCache(int cacheSize) {
    this.cacheSize = cacheSize;
    this.cache = new HashMap<>();
    this.queue = new LinkedList<>();
  }

  @Override public void put(Integer key, Integer value) {
    if (!cache.containsKey(key)) {
      if (cacheSize == queue.size()) {
        final Integer removedKey = queue.removeLast();
        cache.remove(removedKey);
      }
    } else {
      queue.remove(key);
    }
    cache.put(key, value);
    queue.addFirst(key);
  }

  @Override public Integer get(Integer key) {
    final Integer integer = cache.get(key);
    if (null == integer) {
      return null;
    }
    queue.remove(key);
    queue.addFirst(key);
    return integer;
  }
}
