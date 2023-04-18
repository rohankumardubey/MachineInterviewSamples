package org.apache.arrays;

import java.util.Arrays;

public class ArrayEX9 {
  public static void main(String[] args) {
    int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    Arrays.sort(arr);
    Arrays.sort(dep);
    int required=0;
    int result= 0;
    int i =0;
    int j = 0;
    while(i< arr.length && j<dep.length) {
      if(arr[i]<=dep[j]) {
        required++;
        if(required>result) {
          result=required;
        }
        i++;
      } else {
        required--;
        j++;
      }
    }
    System.out.println(result);
  }
}
