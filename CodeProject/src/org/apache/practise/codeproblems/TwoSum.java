package org.apache.practise.codeproblems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    int[] a = { 2, 7, 11, 15 };
    int requiredSum = 40;
    Map<Integer, Integer> map = new HashMap<>();
    boolean isFound = false;
    for (int i = 0; i < a.length; i++) {
      final Integer integer = map.get(requiredSum - a[i]);
      if (null != integer) {
        if (integer == a[i] && integer > 1) {
          isFound = true;
          break;
        } else {
          isFound = true;
          break;
        }
      } else {
        final int i1 = map.getOrDefault(a[i], 0) + 1;
        map.put(a[i], i1);
      }
    }
    System.out.println(isFound);
  }
}
