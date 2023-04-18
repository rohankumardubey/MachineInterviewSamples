package org.apache.practise.designproblems;

import java.util.Arrays;

public class MyInteger {
  public static void main(String[] args) {
    //    String s = "2147483648" + "";
    //    String s = Long.MAX_VALUE+"";

    //    System.out.println(s);
    //    String s = "";
    //        final int i = parseInt(s,10);
    //    final int i = parseIntMine(s);
    //    System.out.println(i);
    //    System.out.println(i);

    //    System.out.println(Character.digit('1', 10));
    //    System.out.println(Integer.parseInt(""));
    //        int a[] = {10,9,30,20,1,2,3,4,5};
    //    String data[] = { "vishal", "akash", "shi", "kunal" };
    //    String[] b = data.clone();
    //    mergeSort(b, data, 0, data.length, 0);
    //    System.out.println(Arrays.toString(data));

    //    myPow(2,7);
    final int fab = fib(9);
    System.out.println(fab);

  }

  /**
   * Swaps x[a] with x[b].
   */
  private static void swap(Object[] x, int a, int b) {
    Object t = x[a];
    x[a] = x[b];
    x[b] = t;
  }

  private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
    int length = high - low;
    // Insertion sort on smallest arrays
    if (length < 2) {
      for (int i = low; i < high; i++) {
        for (int j = i; j > low && ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--) {
          swap(dest, j, j - 1);
        }
      }
      return;
    }

    // Recursively sort halves of dest into src
    int destLow = low;
    int destHigh = high;
    low += off;
    high += off;
    int mid = (low + high) >>> 1;
    mergeSort(dest, src, low, mid, -off);
    mergeSort(dest, src, mid, high, -off);

    // If list is already sorted, just copy from src to dest.  This is an
    // optimization that results in faster sorts for nearly ordered lists.
    if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
      System.arraycopy(src, low, dest, destLow, length);
      return;
    }

    // Merge sorted halves (now in src) into dest
    for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
      if (q >= high || p < mid && ((Comparable) src[p]).compareTo(src[q]) <= 0) {
        dest[i] = src[p++];
      } else {
        dest[i] = src[q++];
      }
    }
  }

  public static int parseInt(String s, int radix) throws NumberFormatException {
    if (s == null) {
      throw new NumberFormatException("null");
    }

    if (radix < Character.MIN_RADIX) {
      throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
    }

    if (radix > Character.MAX_RADIX) {
      throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
    }

    int result = 0;
    boolean negative = false;
    int i = 0, len = s.length();
    int limit = -Integer.MAX_VALUE;
    int multmin;
    int digit;

    if (len > 0) {
      char firstChar = s.charAt(0);
      if (firstChar < '0') { // Possible leading "+" or "-"
        if (firstChar == '-') {
          negative = true;
          limit = Integer.MIN_VALUE;
        } else if (firstChar != '+') throw new NumberFormatException(s);

        if (len == 1) // Cannot have lone "+" or "-"
          throw new NumberFormatException(s);
        i++;
      }
      multmin = limit / radix;
      while (i < len) {
        // Accumulating negatively avoids surprises near MAX_VALUE
        digit = Character.digit(s.charAt(i++), radix);
        if (digit < 0) {
          throw new NumberFormatException(s);
        }
        if (result < multmin) {
          throw new NumberFormatException(s);
        }
        result *= radix;
        if (result < limit + digit) {
          throw new NumberFormatException(s);
        }
        result -= digit;
      }
    } else {
      throw new NumberFormatException(s);
    }
    return negative ? result : -result;
  }

  private static Integer parseIntMine(String s) {
    if (s == null || s.isEmpty()) {
      throw new NumberFormatException("Invalid string");
    }
    s = s.trim();
    int base = 10;
    int startIndex = 0;
    int len = s.length();
    boolean isNegative = false;
    char c = s.charAt(0);
    int limit = -Integer.MAX_VALUE;
    int maxLimit = 10;
    if (c < '0') {
      if (c == '-') {
        isNegative = true;
        limit = Integer.MIN_VALUE;
      } else if (c != '+') {
        throw new NumberFormatException(s);
      }
      if (len == 1) {
        throw new NumberFormatException(s);
      }
      startIndex++;
      limit = limit / base;
      maxLimit = 11;
    }
    if (s.length() > maxLimit) {
      throw new NumberFormatException(s);
    }
    int number;
    int result = 0;
    while (startIndex < len) {
      number = Character.digit(s.charAt(startIndex++), 10);
      if (number < 0) {
        throw new NumberFormatException(s);
      }
      if (result < limit) {
        throw new NumberFormatException(s);
      }
      result *= base;
      if (result < limit + number) {
        throw new NumberFormatException(s);
      }
      result -= number;
    }
    return isNegative ? result : -result;
  }

  // Decodes bytes string to integer
  public static int stringToInt(char bytesStr) {
    int result = 0;
    result = (result << 8) + (int) bytesStr;
    return result;
  }

  public static double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    double ans = 1;
    double current_product = x;
    for (long i = N; i > 0; i /= 2) {
      if ((i % 2) == 1) {
        ans = ans * current_product;
      }
      current_product = current_product * current_product;
    }
    return ans;
  }

  public int mySqrt(int x) {
    if (x < 2) return x;
    double x0 = x;
    double x1 = (x0 + x / x0) / 2.0;
    while (Math.abs(x0 - x1) >= 1) {
      x0 = x1;
      x1 = (x0 + x / x0) / 2.0;
    }
    return (int) x1;
  }

  private double fastPow(double x, long n) {
    if (n == 0) {
      return 1.0;
    }
    double half = fastPow(x, n / 2);
    if (n % 2 == 0) {
      return half * half;
    } else {
      return half * half * x;
    }
  }

  public double myPowR(double x, int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    return fastPow(x, N);
  }

  private static int fab(int n) {
    int a[][] = { { 1, 1 }, { 1, 0 } };
    int b[][] = { { 1, 1 }, { 1, 0 } };
    if (n == 0) {
      return 0;
    }
    for (int i = 2; i <= n; i++) {
      int x = a[0][0] * b[0][0] + a[0][1] * b[1][0];
      int y = a[0][0] * b[0][1] + a[0][1] * b[1][1];
      int z = a[1][0] * b[0][0] + a[1][1] * b[1][0];
      int w = a[1][0] * b[0][1] + a[1][1] * b[1][1];
      a[0][0] = x;
      a[0][1] = y;
      a[1][0] = z;
      a[1][1] = w;
    }
    return a[0][0];
  }

  static int fib(int n) {
    int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
    if (n == 0) return 0;
    power(F, n - 1);

    return F[0][0];
  }

  /* Helper function that multiplies 2 matrices F and M of size 2*2, and
  puts the multiplication result back to F[][] */
  static void multiply(int F[][], int M[][]) {
    int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
    int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
    int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
    int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
  }

  /* Helper function that calculates F[][] raise to the power n and puts the
  result in F[][]
  Note that this function is designed only for fib() and won't work as general
  power function */
  static void power(int F[][], int n) {
    int i;
    int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };

    // n - 1 times multiply the matrix to {{1,0},{0,1}}
    for (i = 2; i <= n; i++) {
      multiply(F, M);
    }
  }
}
