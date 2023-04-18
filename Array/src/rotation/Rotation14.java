package rotation;

import java.util.Arrays;

//Split the array and add the first part to the end
public class Rotation14 {
  public static void main(String[] args) {
    int arr[] = {12, 10, 5, 6, 52, 36};
    int k = 2;
    split(arr, k);
    System.out.println(Arrays.toString(arr));

  }

  private static void split(int[] a, int k) {
    for (int i = 0, j = k-1; i <=j; i++,j--) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }

    for (int i = k, j = a.length-1; i <=j; i++,j--) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }

    for (int i = 0, j = a.length-1; i <=j ; i++,j--) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
}
