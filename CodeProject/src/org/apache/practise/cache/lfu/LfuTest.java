package org.apache.practise.cache.lfu;

public class LfuTest {
  public static void main(String[] args) {
    LfuCache cache = new LfuCache(4);
    cache.put(1,10);
    cache.put(1,11);
    cache.put(1,12);
    cache.put(2,20);
    cache.put(3,30);
    cache.put(4,40);
    cache.put(5,50);
  }
}
