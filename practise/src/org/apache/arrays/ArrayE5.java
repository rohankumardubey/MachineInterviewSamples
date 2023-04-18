package org.apache.arrays;
//Equilibrium point
public class ArrayE5 {
  public static void main(String[] args) {
    int a[] = {1,3,5,2,2};
    int totalSum = 0;
    for (int i = 0; i < a.length; i++) {
        totalSum+=a[i];
    }
    int leftSum =0;
    for (int i = 0; i < a.length; i++) {
      totalSum-=a[i];
      if(leftSum == totalSum) {
        System.out.println(a[i]);
        break;
      }
      leftSum +=a[i];
    }
  }
}
