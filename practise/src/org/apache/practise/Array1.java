package org.apache.practise;

public class Array1 {
  public static void main(String[] args) {
    int[] a = {1,2,3,7,5};
    int requiredSum = 12;
    int currentSum = a[0];
    int start = 0;
    for (int i = 1; i < a.length; i++) {
      currentSum+=a[i];
      if(currentSum>requiredSum) {
        currentSum-=a[i];
        start++;
      }
      if(currentSum == requiredSum) {
        System.out.println((start + 1) + "," + (i+1));
      }
    }
  }
}
