package org.apache.Hashing;

import java.util.HashSet;
import java.util.Set;

//Print all pairs with given sum
public class HashingExtra1 {
  public static void main(String[] args) {
    int[] arr = {1, 5, 1, 7, -1, 5};
    int sum = 6;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      int remaining = sum - arr[i];
      if(set.contains(remaining)) {
        System.out.println("(" + arr[i] + "," + remaining + ")");
      }
        set.add(arr[i]);
    }
  }
}
