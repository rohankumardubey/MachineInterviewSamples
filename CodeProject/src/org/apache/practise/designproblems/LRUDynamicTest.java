package org.apache.practise.designproblems;

public class LRUDynamicTest {
  public static void main(String[] args) {
    LRUDynamic lruDynamic = new LRUDynamic(2);
    lruDynamic.put(1,1);
    lruDynamic.put(2,2);
    lruDynamic.put(1,2);
    lruDynamic.put(3,3);
  }
}
