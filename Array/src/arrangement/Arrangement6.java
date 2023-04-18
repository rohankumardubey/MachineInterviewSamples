package arrangement;

import java.util.Arrays;

//Move all zeroes to end of array
//Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).
public class Arrangement6 {
  public static void main(String[] args) {
    int a[] = {1, 2, 0, 4, 3, 0, 5, 0};
    int zero = 0;
    for (int i = 0; i < a.length; i++) {
      if(a[i]==0) {
        zero++;
      }
    }
    int fillIndex = 0;
    for (int i = 0; i < a.length; i++) {
      if(a[i]!=0) {
        a[fillIndex++] = a[i];
      }
    }
    for (int i = a.length-zero; i < a.length; i++) {
      a[i]=0;
    }
    System.out.println(Arrays.toString(a));
  }
}
