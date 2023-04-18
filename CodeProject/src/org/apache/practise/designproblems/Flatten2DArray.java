package org.apache.practise.designproblems;

import java.util.Iterator;

public class Flatten2DArray implements Iterator<Integer> {
  private int index;
  private int[][] data;
  private Iterator<Integer> dataIterator;

  public Flatten2DArray(int[][] data) {
    this.data = data;
  }

  @Override public boolean hasNext() {
    if (index < this.data.length && (dataIterator == null || !dataIterator.hasNext())) {
      dataIterator = new ArrayIterator(data[index]);
      index++;
      return true;
    } else if(dataIterator.hasNext()) {
      return true;
    } else {
      return false;
    }
  }

  @Override public Integer next() {
    return dataIterator.next();
  }

  private class ArrayIterator implements Iterator<Integer> {
    private int[] data;
    private int counter;

    private ArrayIterator(int[] data) {
      this.data = data;
    }

    @Override public boolean hasNext() {
      return counter < data.length;
    }

    @Override public Integer next() {
      return data[counter++];
    }
  }
}
