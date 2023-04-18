package org.apache.Hashing;

import java.util.HashSet;
import java.util.Set;

//Longest consecutive subsequence
public class Hashing5 {
  public static void main(String[] args) {
    int a[] = {2 ,6 ,1, 9, 4, 5, 3};
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      set.add(a[i]);
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      if(!set.contains(a[i]-1)) {
        int j = a[i];
        while(set.contains(j)) {
          j++;
        }
        if(max<j-a[i]) {
          max = j-a[i];
        }
      }
    }
    System.out.println(max);
  }
}
