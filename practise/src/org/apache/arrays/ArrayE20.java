package org.apache.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given two arrays A1[] and A2[] of size N and M respectively.
// The task is to sort A1 in such a way that the relative order among the elements
// will be same as those in A2. For the elements not present in A2,
// append them at last in sorted order. It is also given that the number of
// elements in A2[] are smaller than or equal to number of elements in A1[] and A2[]
// has all distinct elements
public class ArrayE20 {
  public static void main(String[] args) {
    int a[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    int b[] = {5, 5, 5, 5};
    List<Integer> data = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      data.add(a[i]);
    }
    Collections.sort(data, new ArrayComparator(b));
    System.out.println(data);

  }
  private static class ArrayComparator implements Comparator<Integer> {
    int[] actual;
    public ArrayComparator(int[] actualArray) {
      this.actual = actualArray;
    }
    @Override public int compare(Integer o1, Integer o2) {
      int firstIndex = -1;
      int secondIndex = -1;
      for (int i = 0; i < actual.length; i++) {
        if(actual[i]==o1) {
          firstIndex=i;
          break;
        }
      }
      for (int i = 0; i < actual.length; i++) {
        if(actual[i]==o2) {
          secondIndex=i;
          break;
        }
      }
      if(firstIndex == secondIndex) {
        return o1-o2;
      } else if(firstIndex==-1) {
        return 1;
      } else if(secondIndex==-1) {
        return -1;
      } else {
        return firstIndex-secondIndex;
      }
    }
  }
}
