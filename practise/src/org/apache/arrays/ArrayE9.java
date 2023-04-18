package org.apache.arrays;

//Maximum of all subarrays of size k
//Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.
public class ArrayE9 {
  public static void main(String[] args) {
        int a[]= {1,2,3,1,4,5,2,3,6};
//    int a[] = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
    int startIndex = 1;
    int k = 3;
    for (int i = 0; i < a.length - k + 1; i++) {
      int max = a[i];
      for (int j = i+1; j < a.length && j < i + k; j++) {
        if (max < a[j]) {
          max = a[j];
        }
      }
      System.out.println(max);
    }
  }

}
