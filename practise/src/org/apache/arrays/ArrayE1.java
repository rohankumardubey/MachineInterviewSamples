package org.apache.arrays;
//Subarray with given sum
public class ArrayE1 {
  public static void main(String[] args) {
    int[] a = {1,2,3,7,5};
    int sum=a[0];
    int start=0;
    int requiredSum=12;
    for (int i = 1; i < a.length; i++) {
        sum+=a[i];
        if(sum>requiredSum) {
          sum-=a[start];
          start++;
        }
        if(sum==requiredSum) {
          System.out.println( (start +1 )+  "," + (i + 1));
        }
    }
  }
}
