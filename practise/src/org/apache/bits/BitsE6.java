package org.apache.bits;

//Power of 2
public class BitsE6 {
  public static void main(String[] args) {
    int num = 6;
    if(num==0) {
      System.out.println(false);
    } else {
      System.out.println((num & (num-1))==0);
    }
  }
}
