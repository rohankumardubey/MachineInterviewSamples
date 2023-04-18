package org.apache.arrays;

import java.util.Arrays;

//Minimum Number of Platforms Required for a Railway/Bus Station
public class ArrayE8 {
  public static void main(String[] args) {
    int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    System.out.println(numberOfPlatform(arr,dep));
  }

  private static int numberOfPlatform(int []a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);
    int i = 0;
    int j = 0;
    int result = Integer.MIN_VALUE;
    int required = 0;
    while(i<a.length && j<b.length) {
      if(a[i]<=b[j]) {
        required++;
        if(result<required) {
          result = required;
        }
        i++;
      } else {
        required--;
        j++;
      }

    }
    return result;
  }
}
