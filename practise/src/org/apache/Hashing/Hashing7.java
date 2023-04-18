package org.apache.Hashing;

import java.util.HashSet;
import java.util.Set;

// pair of given sum
public class Hashing7 {
  public static void main(String[] args) {
//    int[] a ={-1,2,4,5,7};
//    int[] b = {5,6,-3,4,8};
//    int sum = -4;
    int[] a = {0,2};
    int[]b = {1,3};
    int sum = 3;
    printPair(a,b,sum);
  }

  private static void printPair(int[] a, int []b, int sum) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i <a.length; i++) {
      set.add(a[i]);
    }
    for (int i = 0; i < b.length; i++) {
      if(set.contains(sum - b[i])) {
        System.out.println("(" + b[i] + "," + (sum- b[i]) + ")");
      }
    }
  }

}
