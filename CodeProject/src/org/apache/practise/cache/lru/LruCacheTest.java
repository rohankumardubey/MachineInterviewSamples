package org.apache.practise.cache.lru;

public class LruCacheTest {
  public static void main(String[] args) {
    LruCache cache  = new LruCache(3);
    cache.put(1,1);
    cache.put(2,3);
    cache.put(3,3);
    cache.get(2);
    cache.put(4,4);
  }
}
