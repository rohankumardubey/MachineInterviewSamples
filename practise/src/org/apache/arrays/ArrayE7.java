package org.apache.arrays;

//Leaders in an array
public class ArrayE7 {
  public static void main(String[] args) {
    //    int a[] = {16,17,4,3,5,2};
    //    int a[] = {1,2,3,4,0};
    int a[] = { 7, 4, 5, 7, 3 };
    int currentMax = a[a.length - 1];
    for (int i = a.length - 2; i >= 0; i--) {
      if (currentMax <= a[i]) {
        System.out.println(currentMax);
        currentMax = a[i];
      }
    }
    System.out.println(currentMax);
  }
}
