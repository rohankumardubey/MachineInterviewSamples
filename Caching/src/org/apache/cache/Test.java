package org.apache.cache;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Test {
  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<>();
    a.add(1);
    a.add(2);
    a.add(3);
    a.add(4);
    System.out.println(a.pollFirst());
    System.out.println(a.pollLast());
    LinkedHashMap map = new LinkedHashMap();
  }
}
