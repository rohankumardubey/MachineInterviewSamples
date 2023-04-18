package org.apache.practise.codeproblems;

public class MaxSubArray {
  public static void main(String[] args) {
    int a[] = {};
    int maxSum = a[0];
    for (int i = 1; i < a.length; i++) {
      if(a[i-1] > 0) {
        a[i]+=a[i-1];
      }
      maxSum = Math.max(a[i],maxSum);
    }
  }
}
