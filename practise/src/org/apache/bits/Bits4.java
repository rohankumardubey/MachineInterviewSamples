package org.apache.bits;

//ith bit is set or not
public class Bits4 {
  public static void main(String[] args) {
    int n = 6;
    System.out.println((n & (1<<3))>0);
  }
}
