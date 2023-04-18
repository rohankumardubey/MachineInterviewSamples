package org.apache.Hashing;

import java.util.HashMap;
import java.util.Map;

//Count distinct elements in every window
//Given an array A[] of size N and an integer K. Your task is to complete the function
// countDistinct() which prints the count of distinct numbers in all windows of size k in
// the array A[].
public class Hashing3 {
  public static void main(String[] args) {
    int[] a = { 1, 2, 1, 3, 4, 2, 3 };
    int k = 4;
    Map<Integer, Integer> set = new HashMap<>();
    int firstelement = 0;
    int counter = 0;
    for (int i = 0; i < a.length; i++) {
      Integer integer = set.get(a[i]);
      if (integer == null) {
        set.put(a[i], 1);
      } else {
        set.put(a[i], ++integer);
      }
      counter++;
      if (counter >= k) {
        System.out.println("distinct: " + set.size());
        Integer integer1 = set.get(a[firstelement]);
        if (integer1 == 1) {
          set.remove(a[firstelement]);
        } else {
          set.put(a[firstelement], --integer1);
        }
        firstelement++;
        counter--;
      }
    }

  }
}
