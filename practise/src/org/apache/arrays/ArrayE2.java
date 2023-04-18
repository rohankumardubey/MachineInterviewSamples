package org.apache.arrays;

//Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
//Kadane's Algorithm
public class ArrayE2 {
  public static void main(String[] args) {
    int[] a = {-1,-2,-3,20,-5};
    int maxEndingHere = a[0];
    int maxSoFar = a[0];
    int start = 0;
    int end = 0;
    int tempIndex = 0;
    int currentSum = a[0];
    for (int i = 1; i < a.length; i++) {
      currentSum += a[i];
      if(a[i] > currentSum) {
        tempIndex=i;
      }
      maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
      if(maxSoFar<maxEndingHere) {
        maxSoFar = maxEndingHere;
        end = i;
        start = tempIndex;
      }
    }
    System.out.println(maxSoFar);
    System.out.println(start);
    System.out.println(end);
  }
}
