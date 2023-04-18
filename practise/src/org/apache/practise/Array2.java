package org.apache.practise;

import java.util.Arrays;

public class Array2 {
  public static void main(String[] args) {
    int [] a= {1,2,5,3};
    Arrays.sort(a);
    int current = a[a.length-1];
    for (int i = a.length-2; i >=1 ; i--) {
      if(current == a[i]+a[i-1]) {
        System.out.println(a[i-1] + "+" + a[i] + "=" +current);
      }
      current=a[i];
    }
  }
}
