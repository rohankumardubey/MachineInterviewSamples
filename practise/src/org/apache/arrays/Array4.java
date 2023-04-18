package org.apache.arrays;

import java.util.Arrays;

// Print all pairs with given sum
public class Array4 {
  public static void main(String[] args) {
    int[] arr = {1, 5, 7, -1, 5};
    Arrays.sort(arr);
    printPair(arr, 6);
  }

  private static void printPair(int[] a, int sum) {
    int low = 0;
    int high  = a.length-1;
    while(low<high) {
      if(a[low] + a[high] == sum) {
        System.out.println("(" + a[low] + "," + a[high]+")");
      }
      if(a[low] + a[high] > sum) {
        high--;
      } else {
        low++;
      }
    }
  }
}
