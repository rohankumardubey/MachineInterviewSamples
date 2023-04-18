package org.apache.practise.cache.mru;

public class MruTest {
  public static void main(String[] args) {
    MruCache cache  = new MruCache(3);
    cache.put(1,1);
    cache.put(2,3);
    cache.put(3,3);
    cache.get(2);
    cache.put(4,4);
  }
}
