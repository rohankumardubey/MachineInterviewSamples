package org.apache.recursion;

import java.util.ArrayList;
import java.util.List;

public class Recusrion {
  public static void main(String[] args) {
//    System.out.println(numberOfDigit(1234));
//    System.out.println(exponentOfNumber(2,4));
   check(5);
  }

  private static void check(int i) {
    if(i==0) {
      return;
    }
    check(i-1);
    System.out.println(i);
  }
  private static int mod(int dividend, int divisor) {
    if(divisor==0) {
      return -1;
    }
    if(dividend<divisor) {
      return dividend;
    }
    return mod(dividend-divisor, divisor);
  }

  private static int sumOfAllNumber(int num) {
    if(num==0) {
      return 0;
    }
    return num+sumOfAllNumber(num-1);
  }
  private static int numberOfDigit(int number) {
    if(number==0) {
      return 1;
    }
    return 1+numberOfDigit(number/10);
  }

  private static int exponentOfNumber(int num, int pow) {
    if(pow==0) {
      return 1;
    }

    return num * exponentOfNumber(num, pow-1);
  }

  private static int fibonacci(int n) {
    // Base case
    if (n <= 1) {
      return n;
    }
    // Recursive case
    else {
      return (fibonacci(n-1) + fibonacci(n-2));
    }
  }

  private static boolean isPrime(int num, int num1) {
    if(num<2) {
      return false;
    }
    if(num1==1) {
      return true;
    }
    if(num%num1==2) {
      return false;
    }
    return isPrime(num, num1-1);
  }

  private static int binary(int num) {
    if(num==0) {
      return 0;
    }
    return num%2 + 10 * binary(num/2);
  }


}
