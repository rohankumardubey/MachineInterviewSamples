package org.apache.arrays;

import java.util.Arrays;

public class ArrayE4 {
  public static void main(String[] args) {
    int a[] ={0,2,1,2,0};
    int zeroCounter = 0;
    int oneCounter = 0;
    for (int i = 0; i < a.length; i++) {
      if(a[i]==0) {
        zeroCounter++;
      } else if(a[i]==1) {
        oneCounter++;
      }
    }
    for (int i = 0; i <zeroCounter; i++) {
      a[i] = 0;
    }
    for (int i = zeroCounter; i < oneCounter; i++) {
      a[i] = 1;
    }
    for (int i = zeroCounter+oneCounter; i < a.length; i++) {
      a[i] = 2;
    }
    System.out.println(Arrays.toString(a));
  }
}
