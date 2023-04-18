package org.apache.bits;
// Check whether K-th bit is set or not
public class BitsE3 {
  public static void main(String[] args) {
    int num = 1000;
    int k = 2;
    System.out.println((num & (1<<k))>0);
  }
}
