package org.apache.Hashing;

import java.util.HashSet;
import java.util.Set;

//Array Subset of another array
public class Hashing6 {
  public static void main(String[] args) {
    int[] a = {10,5,2,23,19};
    int[] b = {19,5,3};
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
        set.add(a[i]);
    }
    boolean isPresent = true;
    for (int i = 0; i < b.length; i++) {
      if(!set.contains(b[i])) {
        isPresent = false;
      }
    }
    if(isPresent) {
      System.out.println("present");
    } else {
      System.out.println("not present");
    }
  }
}
