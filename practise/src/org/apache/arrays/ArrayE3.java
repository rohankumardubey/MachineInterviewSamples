package org.apache.arrays;
//Missing number in array
public class ArrayE3 {
  public static void main(String[] args) {
    int a[] = {1,2,3,4,5,6,7,8,10};
    int n = 10;
    int currentSum = 0;
    for (int i = 0; i < a.length; i++) {
      currentSum+=a[i];
    }
    System.out.println((n*(n+1))/2 -currentSum);
  }

}
