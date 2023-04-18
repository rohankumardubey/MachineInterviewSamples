package rotation;

import java.util.Arrays;
//Right rotation
public class Rotation11 {
  public static void main(String[] args) {
    int a[]= {1,2,3,4,5};
    int k  = 2;
    reverse(a, 0, a.length-1);
    reverse(a, 0, k-1);
    reverse(a, k, a.length-1);
    System.out.println(Arrays.toString(a));
  }
  
  private static void reverse(int a[], int start, int end) {
    for (int i = start,j=end; i <=j ; i++,j--) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
}
