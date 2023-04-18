package org.apache.arrays;
//Find the element that appears once in sorted array
public class ArrayE18 {
  public static void main(String[] args) {
    int a[] ={1,1,2,2,3,4,4,50,50,65,65};
    int v = 0;
    for (int i = 0; i < a.length; i++) {
      v = a[i]^v;
    }
    System.out.println(v);
  }
}
