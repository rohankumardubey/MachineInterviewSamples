package org.apache.practise.designproblems;

import java.util.Arrays;

public class MyHashMap {
  private int[][] data;

  public MyHashMap(int capacity) {
    int size = capacity / 8;
    if (capacity % 8 > 0) {
      size++;
    }
    data = new int[size][];
  }

  public void put(int key, int value) {
    final int rowIndex = key / 8;
    if (rowIndex >= data.length) {
      int[][] newData = new int[data.length + 100][];
      for (int i = 0; i < data.length; i++) {
        if (data[i] != null) {
          newData[i] = new int[data[i].length];
          System.arraycopy(data[i], 0, newData[i], 0, data[i].length);
        }
      }
      this.data = newData;
    }
    if (data[rowIndex] == null) {
      data[rowIndex] = new int[8];
      Arrays.fill(data[rowIndex], -1);
    }
    int columnIndex = key % 8;
    data[rowIndex][columnIndex] = value;
  }

  public int get(int key) {
    final int rowIndex = key / 8;
    if (data[rowIndex] == null) {
      return -1;
    }
    int columnIndex = key % 8;
    return data[rowIndex][columnIndex];
  }

  public void remove(int key) {
    final int rowIndex = key / 8;
    if (data[rowIndex] == null) {
      return;
    }
    int columnIndex = key % 8;
    data[rowIndex][columnIndex] = -1;
  }
}
