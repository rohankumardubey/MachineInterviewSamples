package org.apache.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Array1 {

  //  Given an array of elements of length N, ranging from 0 to N-1,
  // your task is to write a program that rearranges the elements of the array.
  // All elements may not be present in the array, if element is not present then there
  // will be -1 present in the array. Rearrange the array such that A[i] = i and
  // if i is not present, display -1 at that place.
  //  Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
  //  Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
  //
  //  Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
  //      11, 10, 9, 5, 13, 16, 2, 14, 17, 4}
  //  Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
  //      11, 12, 13, 14, 15, 16, 17, 18, 19]
  public static void main(String[] args) {
    int[] arr =  {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
    System.out.println(Arrays.toString(arrange1(arr)));
  }

  private static int[] arrange(int[] arr) {
    int [] output = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      int element = -1;
      for (int j = 0; j < arr.length; j++) {
        if (i == arr[j]) {
          element = i;
        }
      }
      output[i] = element;
    }
    return output;
  }

  private static int[] arrange1(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
        set.add(arr[i]);
    }
    for (int i = 0; i < arr.length; i++) {
      if(set.contains(i)) {
        arr[i] = i;
      }else {
        arr[i] = -1;
      }
    }

    return arr;
  }
}
