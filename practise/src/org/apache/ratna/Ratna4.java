package org.apache.ratna;

public class Ratna4 {
  public static void main(String[] args) {
    int a[] = { 7, 4, 5, 7, 3 };
    int currentMax = a[a.length-1];
    for (int i = a.length-2; i >=0 ; i--) {
      if(a[i]>=currentMax) {
        System.out.println(currentMax);
        currentMax = a[i];
      }
    }
    System.out.println(currentMax);
  }
}
