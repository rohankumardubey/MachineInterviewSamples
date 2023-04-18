package arrangement;

import java.util.Arrays;

//Rearrange array in alternating positive & negative items with O(1) extra space | Set 1
//Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
//Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.
public class Arrangement5 {
  public static void main(String[] args) {
    int a[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    
    int positiveIndex  = -1;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < 0) {
        positiveIndex++;
        int temp = a[i];
        a[i] = a[positiveIndex];
        a[positiveIndex] = temp;
      }
    }
      positiveIndex++;
      int neg = 1;
      while(neg<positiveIndex) {
        if(a[neg] <0) {
          int temp = a[neg];
          a[neg] = a[positiveIndex];
          a[positiveIndex] = temp;
          neg+=2;
          positiveIndex++;
        }
      }
    System.out.println(Arrays.toString(a));
    }
}
