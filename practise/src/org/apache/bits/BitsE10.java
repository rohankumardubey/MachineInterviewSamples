package org.apache.bits;
//Count total set bits
public class BitsE10 {
  public static void main(String[] args) {
    int num = 3;
    int counter = 0;
    while(num>0) {
      num = num & (num-1);
      counter++;
    }
    System.out.println(counter);
  }
}
