package arrangement;

import java.util.Arrays;

public class Arrangement12 {
  public static void main(String[] args) {
    int a[] = {2, 2, 0, 4, 0, 8};
    for (int i = 0; i < a.length-1; ) {
      if(a[i] ==a[i+1]) {
        a[i]*=2;
        a[i+1]=0;
        i+=2;
      } else {
        i++;
      }
    }
    System.out.println(Arrays.toString(a));
    int nonZeroIndex = -1;
    for (int i = 0; i < a.length; i++) {
      if(a[i]!=0) {
        nonZeroIndex++;
        int temp =a[nonZeroIndex];
        a[nonZeroIndex] = a[i];
        a[i] = temp;
      }
    }
    System.out.println(Arrays.toString(a));
  }
}
