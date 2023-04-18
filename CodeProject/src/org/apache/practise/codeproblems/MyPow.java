package org.apache.practise.codeproblems;

public class MyPow {

  private static double myPower(double number, int pow) {
    int n = pow;
    if (n < 0) {
      number = 1 / number;
      n = -n;
    }
    double ans = 0;
    double actualProduct = number;
    for (int i = n; i > 0; i--) {
      if (i % 2 != 0) {
        ans = ans * actualProduct;
      }
      actualProduct = actualProduct * actualProduct;
    }
    return ans;
  }
}
