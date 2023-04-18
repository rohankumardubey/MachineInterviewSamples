package org.apache.practise.codeproblems;

public class MyParseInt {

  public static void main(String[] args) {
    final int i = parseInt("10");
    System.out.println(i);
  }
  public static int parseInt(String number) {
    if(null==number || number.length()==0) {
      throw new NumberFormatException("Invalid number");
    }
    int result = 0;
    boolean isNeg = false;
    int maxLimit  = -Integer.MAX_VALUE;
    int maxChar = 10;
    int currentIndex = 0;
    char c  = number.charAt(result);
    if(c < '0') {
      if(c=='-') {
        isNeg = true;
        maxLimit = Integer.MIN_VALUE;
      } else if(c!='+') {
        throw new NumberFormatException("Invalid number");
      }
      if(number.length()==1) {
        throw new NumberFormatException("Invalid number");
      }
      currentIndex++;
      maxLimit = maxLimit/10;
      maxChar++;
    }
    if(number.length()>maxChar) {
      throw new NumberFormatException("Invalid number");
    }
    int temp;
    while(currentIndex<number.length()) {
      temp = Character.digit(number.charAt(currentIndex++), 10);
      if(temp<0) {
        throw new NumberFormatException("Invalid number");
      }
      if(result<maxLimit) {
        throw new NumberFormatException("Invalid number");
      }
      result*=10;
      if(result< maxLimit+temp) {
        throw new NumberFormatException("Invalid number");
      }
      result-=temp;
    }

    return isNeg?result:-result;
  }
}
