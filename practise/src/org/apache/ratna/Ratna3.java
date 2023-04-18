package org.apache.ratna;

public class Ratna3 {
  public static void main(String[] args) {
    int a[] = {1,3,5,2,2};
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum+=a[i];
    }
    int leftSum = 0;
    for (int i = 0; i < a.length; i++) {
      sum-=a[i];
      if(sum==leftSum) {
        System.out.println(i);
      }
      leftSum+=a[i];
    }
  }
}
