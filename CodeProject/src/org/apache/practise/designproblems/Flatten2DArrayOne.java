package org.apache.practise.designproblems;

import java.util.Iterator;

public class Flatten2DArrayOne implements Iterator<Integer> {
  private int index  = 0;
  private int[][] data;
  private InternalIterator childIterator;
  public Flatten2DArrayOne(int[][] data) {
    this.data = data;
  }
  @Override public boolean hasNext() {
    if(index<data.length &&(childIterator==null || !childIterator.hasNext())) {
      childIterator = new InternalIterator(data[index++]);
      return hasNext();
    } else if(childIterator.hasNext()) {
      return true;
    } else {
      return false;
    }
  }

  @Override public Integer next() {
    return childIterator.next();
  }

  private class InternalIterator implements Iterator<Integer> {
    private int counter=-1;
    private int[] data;
    private InternalIterator(int[] data) {
      this.data = data;
    }

    @Override public boolean hasNext() {
      return counter<data.length;
    }

    @Override public Integer next() {
      return data[++counter];
    }
  }
}
