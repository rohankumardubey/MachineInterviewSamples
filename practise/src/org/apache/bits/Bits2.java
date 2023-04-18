package org.apache.bits;

// count the number of 1 bits
public class Bits2 {
  public static void main(String[] args) {
    int n = 6;
    int counter = 0;
    while(n>0) {
      n = n & (n-1);
      counter++;
    }
    System.out.println(counter);
  }
}
