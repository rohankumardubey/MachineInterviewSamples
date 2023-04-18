package rotation;

import java.util.Arrays;

public class Rotation13 {
  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5};
    sol2(arr, 2);
    System.out.println(Arrays.toString(arr));
  }

  private static void sol2(int a[] , int d) {
    int start = 0;
    int end = d-1;
    while(start<=end) {
      int temp = a[start];
      a[start] = a[end];
      a[end] = temp;
      start++;
      end--;
    }
    start = d;
    end = a.length -1;
    while(start<=end){
      int temp = a[start];
      a[start] = a[end];
      a[end] = temp;
      start++;
      end--;
    }
    start = 0;
    end = a.length-1;
    while(start<end) {
      int temp = a[start];
      a[start] = a[end];
      a[end] = temp;
      start++;
      end--;
    }
  }
}
