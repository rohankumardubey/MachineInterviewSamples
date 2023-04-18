package org.apache.ratna;

public class Ratna2 {
  public static void main(String[] args) {
    int a[] = {1,2,3,4,5,6,7,8,10};
    int n  = 10;
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum+=a[i];
    }
    System.out.println((n*(n+1))/2-sum);
  }
}
