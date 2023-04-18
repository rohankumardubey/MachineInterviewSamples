package org.apache.practise.designproblems;

public class MergeSort {

  static void merge(int arr[], int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;
    int left[] = new int[n1];
    int right[] = new int[n2];
    for (int i = 0; i < n1; ++i) {
      left[i] = arr[low + i];
    }
    for (int i = 0; i < n2; i++) {
      right[i] = arr[mid + 1 + i];
    }
    int i = 0, j = 0;
    int k = low;
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      arr[k] = left[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = right[j];
      j++;
      k++;
    }
  }

  // Main function that sorts arr[l..r] using
  // merge()
  static void sort(int arr[], int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      sort(arr, low, mid);
      sort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
  }

  public static void main(String[] args) {
    int a[] = { 10, 9, 30, 20, 1, 2, 3, 4, 5 };
    sort(a, 0, a.length - 1);
  }
}
