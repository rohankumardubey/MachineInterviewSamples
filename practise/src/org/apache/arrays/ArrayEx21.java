package org.apache.arrays;

public class ArrayEx21 {
  public static void main(String[] args) {
    int[] a = {-1,-2,-3,20,-5};
    int maxEndingHere = a[0];
    int maxSoFar = a[0];
    int star=0;
    int end=0;
    int currentSum = a[0];
    int tempIndex=0;
    for (int i = 1; i < a.length; i++) {
      currentSum+=a[i];
      if(a[i] > currentSum) {
        tempIndex=i;
      }
      maxEndingHere = Math.max(a[i], maxEndingHere+a[i]);
      if(maxEndingHere>maxSoFar) {
        maxSoFar=maxEndingHere;
        end = i;
        star= tempIndex;
      }
    }
    System.out.println(maxSoFar);
    System.out.println(star);
    System.out.println(end);
  }
}
