package org.apache.arrays;

import java.util.Arrays;

//Given an array (or string), the task is to reverse the array/string.
public class Array2 {
  public static void main(String[] args) {
    int[] a = {1,2,3,4,5};
    reverse(a, 0, a.length-1);
    System.out.println(Arrays.toString(a));
  }

  private static void reverse(int[] array) {
    for (int i = 0, k = array.length-1; i <k ; i++,k--) {
      int temp = array[i];
      array[i] = array[k];
      array[k] = temp;
    }
  }

  private static void reverse(int[] array, int start, int end) {
    if(start>end) {
      return;
    }
    int temp = array[start];
    array[start] = array[end];
    array[end] = temp;
    reverse(array, start+1, end-1);
  }
}
