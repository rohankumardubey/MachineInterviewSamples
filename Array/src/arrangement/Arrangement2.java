package arrangement;

import java.util.Arrays;

//reverse array
public class Arrangement2 {
  public static void main(String[] args) {
    int a[] = {4, 5, 1, 2};
    for (int i = 0, j=a.length-1; i <=j ; i++,j--) {
      int temp = a[i];
      a[i] = a[j];
      a[j] =temp;
    }
    System.out.println(Arrays.toString(a));
  }
}
