package org.apache.Hashing;

import java.util.HashSet;
import java.util.Set;

//Swapping pairs make sum equal
//Given two arrays of integers, write a program to
// check if a pair of values (one value from each array) exists such
// that swapping the elements of the pair will make the sum of two arrays equal.
public class Hashing2 {
  public static void main(String[] args) {
    int a[] = { 4, 1, 2, 1, 1, 2 };
    int b[] = { 3, 6, 3, 3 };
    int sum1 = 0;
    for (int i = 0; i < a.length; i++) {
      sum1 += a[i];
    }
    int sum2 = 0;
    for (int i = 0; i < b.length; i++) {
      sum2 += b[i];
    }
    int add = (sum2-sum1)/2;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < b.length; i++) {
      set.add(b[i]);
    }
    for (int i = 0; i < a.length; i++) {
      if(set.contains(a[i]+add)) {
        System.out.println("swap(" + a[i] + "," + (a[i]+add) + ")");
        break;
      }
    }
  }
}
