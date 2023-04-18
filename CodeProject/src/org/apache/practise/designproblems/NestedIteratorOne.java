package org.apache.practise.designproblems;

import java.util.Iterator;
import java.util.List;

public class NestedIteratorOne implements Iterator<Integer> {
  private List<NestedInteger> nestedIntegerList;
  private int index;
  private NestedIteratorOne childIterator;
  public NestedIteratorOne(List<NestedInteger> nestedIntegerList) {
    this.nestedIntegerList = nestedIntegerList;
  }

  @Override public boolean hasNext() {
    if(null!=nestedIntegerList && index<nestedIntegerList.size()) {
      if(nestedIntegerList.get(index).isInteger()) {
        return true;
      } else {
        if(childIterator==null) {
          childIterator = new NestedIteratorOne(nestedIntegerList.get(index).getDataList());
        }
        if(childIterator.hasNext()) {
          return true;
        } else {
          index++;
          childIterator = null;
          return hasNext();
        }
      }
    }
    return false;
  }

  @Override public Integer next() {
    if(nestedIntegerList.get(index).isInteger()) {
      return nestedIntegerList.get(index++).getData();
    } else {
      return childIterator.next();
    }
  }
}
