package org.apache.arrays;

import java.util.Arrays;

//Pythagorean Triplet
public class ArrayE13 {
  public static void main(String[] args) {
    int[] a = {3,2,7,6,5};
    for (int i = 0; i < a.length; i++) {
      a[i] = a[i] * a[i];
    }
    Arrays.sort(a);
    for (int i = a.length-1; i >= 0; i--) {
      int left = 0;
      int right = i-1;
      while(left<right) {
        if(a[left]+a[right] == a[i]){
          System.out.println(true);
          return;
        }
        if(a[left]+a[right] < a[i]) {
          left++;
        } else{
          right--;
        }
      }
    }
    System.out.println(false);
  }
}
