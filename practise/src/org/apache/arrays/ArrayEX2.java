package org.apache.arrays;

public class ArrayEX2 {
  public static void main(String[] args) {
    int[] a = {-1,-2,-3,20,-5};
    int maxEndingHere = a[0];
    int maxSoFar = a[0];
    for (int i = 1; i < a.length; i++) {
      maxEndingHere = Math.max(a[i], maxEndingHere+a[i]);
      if(maxEndingHere>maxSoFar) {
        maxSoFar=maxEndingHere;
      }
    }
    System.out.println(maxSoFar);
  }
}
