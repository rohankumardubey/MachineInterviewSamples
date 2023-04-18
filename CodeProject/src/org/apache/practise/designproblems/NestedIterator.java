package org.apache.practise.designproblems;

import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

  private List<NestedInteger> nestedIntegerList;

  private int index;

  private NestedIterator childIterator;

  public NestedIterator(List<NestedInteger> nestedIntegerList) {
    this.nestedIntegerList = nestedIntegerList;
  }

  @Override public boolean hasNext() {
    if (null != nestedIntegerList && index < nestedIntegerList.size()) {
      if (nestedIntegerList.get(index).isInteger()) {
        return true;
      } else {
        if (childIterator == null) {
          childIterator = new NestedIterator(nestedIntegerList.get(index).getDataList());
        }
        if (childIterator.hasNext()) {
          return true;
        } else {
          index++;
          childIterator = null;
          return this.hasNext();
        }
      }
    }
    return false;
  }

  @Override public Integer next() {
    if (nestedIntegerList.get(index).isInteger()) {
      return nestedIntegerList.get(index++).getData();
    } else {
      return childIterator.next();
    }
  }
}
