package org.apache.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//Given an array A (distinct elements) of size N.
// Rearrange the elements of array in zig-zag fashion.
// The converted array should be in form a < b > c < d > e < f. The relative order of
// elements is same in the output i.e you have to iterate on the original array only.
public class ArrayE17 {
  public static void main(String[] args) {
    int a[] = { 8, 3, 7, 8, 6, 2, 1 };
////    int a[] = {1,4,3,2};
    zigZag2(a);
    System.out.println(Arrays.toString(a));

  }

  private static void zigZag1(int[] data) {
    Arrays.sort(data);
    for (int i = 1; i < data.length - 1; i += 2) {
      int temp = data[i];
      data[i] = data[i + 1];
      data[i + 1] = temp;
    }
    System.out.println(Arrays.toString(data));
  }

  private static void zigZag2(int[] d) {
    //int a[] ={4,3,7,8,6,2,1};
    boolean flag = true;
    for (int i = 0; i < d.length - 1; i++) {
      if (flag) {
        if (d[i] > d[i + 1]) {
          int temp = d[i];
          d[i] = d[i + 1];
          d[i + 1] = temp;
        }
      } else {
        if (d[i] < d[i + 1]) {
          int temp = d[i];
          d[i] = d[i + 1];
          d[i + 1] = temp;
        }
      }
      flag = !flag;
    }
    System.out.println(Arrays.toString(d));;
  }
}
