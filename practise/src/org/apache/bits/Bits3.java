package org.apache.bits;

// power of 2
public class Bits3 {
  public static void main(String[] args) {
    int n = 60;
    if(n<2) {
      System.out.println(false);
    } else {
      System.out.println((n & (n - 1))==0);
    }
  }
}
