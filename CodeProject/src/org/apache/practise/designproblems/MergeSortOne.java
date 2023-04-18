package org.apache.practise.designproblems;

public class MergeSortOne {

  private void merge(int[] data, int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;
    int left[] = new int[n1];
    int right[] = new int[n2];

    for (int i = 0; i < n1; i++) {
      left[i] = data[low + i];
    }
    for (int i = 0; i < n2; i++) {
      right[i] = data[mid + 1 + i];
    }

    int l = 0;
    int r = 0;
    int k = low;
    while (l < n1 && r < n2) {
      if (left[l] <= right[n2]) {
        data[k] = left[l];
        l++;
      } else {
        data[k] = right[n2];
        r++;
      }
      k++;
    }
    while (l < n1) {
      data[k++] = left[l++];
    }
    while (r < n2) {
      data[k++] = right[r++];
    }
  }

  public void sort(int[] data) {
    sortInternal(data, 0, data.length-1);
  }

  private void sortInternal(int[] data, int low, int high) {
    while(low<=high) {
      int mid = (low+high)/2;
      sortInternal(data, low, mid);
      sortInternal(data, mid+1, high);
      merge(data, low, mid, high);
    }
  }

}
