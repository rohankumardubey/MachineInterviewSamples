package org.apache.arrays;

import java.util.Scanner;

public class ArrayEx1 {
  public static void main(String[] args) {
//    String s = "8 -2 -2 0 8 0 -6 -8 -6 -1";
//    final String[] split = s.split(" ");
//    int a[] = new int[split.length];
//    for (int i = 0; i < a.length; i++) {
//      a[i] = Integer.parseInt(split[i]);
//    }

    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    while(t >0) {
      int n  = scanner.nextInt();
      int a[] = new int[n];
      for (int i = 0; i < a.length; i++) {
        a[i] = scanner.nextInt();
      }
      int counter = 0;

      for (int i = 0; i <a.length ; i++) {
        if(a[i]<0) {
          counter++;
        }
      }
      boolean isCounterOdd = counter%2==0;
      int current =1;
      int totalMax = Integer.MIN_VALUE;
      for (int i = 0; i < a.length; i++) {
        if(a[i]==0 || a[i] < 0 && counter==1 && !isCounterOdd) {
          current =1;
          continue;
        }
        if(a[i] < 0) {
          counter--;
        }
        current*=a[i];
        if(current>totalMax) {
          totalMax = current;
        }
      }
      System.out.println(totalMax);
      t--;
    }
  }
}
