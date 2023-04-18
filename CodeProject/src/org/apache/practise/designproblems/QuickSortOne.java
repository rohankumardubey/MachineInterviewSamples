package org.apache.practise.designproblems;

public class QuickSortOne {

  private int partition(int[]data, int low, int high) {
    int pivote = data[high];
    int i = (low-1);
    for (int j = low; j < high; j++) {
      if(data[low]<pivote) {
        i++;
        int temp = data[j];
        data[j] = data[i];
        data[i] = temp;
      }
    }
    int temp = data[i+1];
    data[i+1] = data[high];
    data[high] = temp;
    return i+1;
  }

  public void sort(int[] data) {
    sortInternal(data, 0, data.length-1);
  }

  private void sortInternal(int data[], int low, int high) {
    while(high<low) {
      final int partition = partition(data, low, high);
      sortInternal(data, low, partition-1);
      sortInternal(data, partition+1, high);
    }
  }
}
