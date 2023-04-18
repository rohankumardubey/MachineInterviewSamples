package org.apache.practise.designproblems;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    String data[] = {"vishal", "akash", "shi", "kunal"};
    quickSort(data, 0, data.length-1);
    System.out.println(Arrays.toString(data));
  }

  private static void quickSort(String [] data, int low, int high) {
    if(low<high) {
      int partition = partition(data, low, high);
      quickSort(data, low, partition-1);
      quickSort(data, partition+1, high);
    }
  }
  private static int partition(String[] data, int low, int high) {
    String pivot = data[high];
    int i =(low -1);
    for (int j = low; j <high ; j++) {
      if(data[j].compareTo(pivot)<0) {
        i++;
        String temp = data[j];
        data[j] = data[i];
        data[i] = temp;
      }
    }
    String temp = data[i+1];
    data[i+1] = data[high];
    data[high] = temp;
    return i+1;
  }
}
