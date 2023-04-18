package org.apache.arrays;

//Element with left side smaller and right side greater
public class ArrayE16 {
  public static void main(String[] args) {
//    int a[]  ={4,3,2,7,8,9};
    int[]a = {11,9,12};
    binarySearch(a);
  }

  private static void binarySearch(int[] data) {
    int low = 0;
    int high = data.length-1;
    int mid = 0;
    while(low<=high) {
      mid = (low+high)/2;
      if(data[mid] > data[low] && data[mid]<data[high]) {
        System.out.println(data[mid]);
        return;
      }
      if(data[mid]>data[high]) {
        high++;
      } else {
        low++;
      }
    }
    System.out.println(-1);
  }
}
