package arrangement;

//Rearrange array such that arr[i] >= arr[j]
// if i is even and arr[i]<=arr[j] if i is odd and j < i

import java.util.Arrays;

//Given an array of n elements. Our task is to write a program to
// rearrange the array such that elements at even positions are
// greater than all elements before it and elements at
// odd positions are less than all elements before it.
public class Arrangement3 {
  public static void main(String[] args) {
    int[] a ={1, 2, 3, 4, 5, 6, 7};
    int[] b = new int[a.length];
    System.arraycopy(a, 0, b,0,a.length);
    Arrays.sort(b);
    int evenPos = a.length / 2;
    int oddPos = a.length - evenPos;
    int j = oddPos - 1;
    for (int i = 0; i < a.length; i += 2) {
      a[i] = b[j];
      j--;
    }
    j = oddPos;
    for (int i = 1; i < a.length; i += 2) {
      a[i] = b[j];
      j++;
    }
    System.out.println(Arrays.toString(a));
  }

}
