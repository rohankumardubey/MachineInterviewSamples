package org.apache.ratna;

public class Ratna1 {
  public static void main(String[] args) {
    int[] a = {1,2,3,7,5};
    int requiredSum = 12;
    int currentSum = a[0];
    int start = 0;
    for (int i = 1; i < a.length; i++) {
       currentSum+=a[i];
       if(currentSum>requiredSum) {
         currentSum-=a[start];
         start--;
       }
       if(requiredSum==currentSum) {
         System.out.println((start+1) + "," +  (i+1));
       }
    }
  }
}
