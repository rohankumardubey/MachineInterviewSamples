package org.apache.arrays;

public class ArrayE24 {
  public static void main(String[] args) {
//    String s =
//        "1 1 0 1 0 0 0 0 1 0 0 0 0 1 1 0 0 0 1 1 1 0 1 0 0 0 1 0"
//      + " 0 1 1 1 0 1 0 1 1 1 1 1 1 1 1 1 1 0 1 1 0 1 0 1 1 0 0 1"
//      + "0 1 1 1 0 0 0 1 0 1 0 1 0 1 0 1 1 1 1 0 0 0 1 0 1 0 0 0 0";
    String s = "0 1 1 1 1 0 0 1 1 0 1 0 1 1 0 0 0 0 0 1 0 1 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 1 0 1 1 1 1 0 1 0 0 1 0 1 0 1 0 0 1 0 0 0 1 1 1 0 1 0 1 0 1 1 1 0 1 0 1 0 1 0 0 1 0 1 0 0 0 0";
    final String[] split = s.split(" ");
    int a[] = new int[split.length];
    for (int i = 0; i < a.length; i++) {
      final int i1 = Integer.parseInt(split[i]);
      if(i1==0) {
        a[i] = -1;
      } else {
        a[i] = i1;
      }
    }
    int maxLen = 0;
    for (int i = 0; i <a.length ; i++) {
      int sum = a[i];
      for (int j = i+1; j < a.length; j++) {
        sum += a[j];
        if(sum==0 && maxLen < j-i+1) {
          maxLen=j-1+1;
        }
      }
    }
    System.out.println(maxLen);
  }
}
