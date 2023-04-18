package arrangement;

import java.util.Arrays;

public class Arrangement7 {
  public static void main(String[] args) {
    int a[]  = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
    int count=-1;
    for (int i = 0; i <a.length; i++) {
      if(a[i]!=0) {
        count++;
        int temp = a[count];
        a[count] = a[i];
        a[i]=temp;
      }
    }
    System.out.println(Arrays.toString(a));
  }
}
