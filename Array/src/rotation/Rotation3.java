package rotation;

import java.util.Arrays;

//Program to cyclically rotate an array by one
//Given an array, cyclically rotate the array clockwise by one.
public class Rotation3 {
  public static void main(String[] args) {
    int a[] = {1, 2, 3, 4, 5};
    cyclicRotateByOne(a);
    System.out.println(Arrays.toString(a));
  }

  private static void cyclicRotateByOne(int a[]) {
    int temp = a[a.length-1];
    for(int i = a.length-2;i>=0;i--) {
      a[i+1] = a[i];
    }
    a[0] = temp;
  }
}
