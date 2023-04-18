package org.apache.bits;
//Find first set bit
public class BitsE1 {
  public static void main(String[] args) {
    int n = 1000;
    int counter = 0;
    System.out.println(n ^ (n & (n - 1)));
    System.out.println((int)((Math.log10(n & -n)) / Math.log10(2)) + 1);
  }

}
