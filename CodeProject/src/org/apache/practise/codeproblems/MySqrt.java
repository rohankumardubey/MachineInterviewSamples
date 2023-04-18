package org.apache.practise.codeproblems;

public class MySqrt {
  public static void main(String[] args) {
    System.out.println(sqrt(2));
  }
  public static double sqrt(int number) {
    if(number<2) {
      return number;
    }
    double first = number;
    double second =(first+number/first)/2.0;

    while(Math.abs(first-second)>=1) {
      first = second;
      second =(first+number/first)/2.0;
    }
    return second;
  }
}
