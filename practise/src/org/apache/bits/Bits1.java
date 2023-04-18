package org.apache.bits;

// number is odd or even
public class Bits1 {
  public static void main(String[] args) {
    int num = 3;
    if((num & 1) == 0) {
      System.out.println("number of is even");
    } else {
      System.out.println("number of is odd");
    }
  }
}
