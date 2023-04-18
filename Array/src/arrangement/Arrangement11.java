package arrangement;

import java.util.Arrays;

public class Arrangement11 {
  public static void main(String[] args) {
    int a[] = {1, 2, 3, 4};
    Arrays.sort(a);
    int[] b  = new int[a.length];
    int p =0;
    int q = a.length-1;
    for (int i = 0; i < a.length; i++) {
      if((i+1)%2 ==0) {
        b[i] = a[q--];
      } else {
        b[i] = a[p++];
      }
    }
    System.out.println(Arrays.toString(b));
  }
}
