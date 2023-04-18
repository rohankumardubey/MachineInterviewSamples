package org.apache.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayE22 {
  public static void main(String[] args) {
//    int[] a ={5,5,4,6,4};
    int[] a ={9,9,9,2,5};
    List<Integer> uniqueValue = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      Integer integer = map.get(a[i]);
      if(null==integer) {
        map.put(a[i],1);
        uniqueValue.add(a[i]);
      } else {
        map.put(a[i],++integer);
      }
    }
    Collections.sort(uniqueValue, new ListComparator(map));
    for (int i = 0; i < uniqueValue.size(); i++) {
      final Integer integer = map.get(uniqueValue.get(i));
      for (int j = 0; j < integer; j++) {
        System.out.println(uniqueValue.get(i));
      }
    }
  }

  private static class ListComparator implements Comparator<Integer> {
    private Map<Integer, Integer> map;
    public ListComparator(Map<Integer, Integer> map) {
      this.map=map;
    }
    @Override public int compare(Integer o1, Integer o2) {
      int frq1 = map.get(o1);
      int frq2 = map.get(o2);
      if (frq1==frq2) {
        return o1-o2;
      } else {
        return -(frq1-frq2);
      }
    }
  }
}
