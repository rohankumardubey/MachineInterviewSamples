package org.apache.practise.test;

import java.util.Iterator;
import java.util.List;

import org.apache.practise.designproblems.NestedInteger;

public class NestestIteratorPractise implements Iterator<Integer> {
  private List<NestedInteger> data;
  private int index;
  private NestestIteratorPractise child;
  public NestestIteratorPractise(List<NestedInteger> data) {
    this.data = data;
  }

  @Override public boolean hasNext() {
    if(data!=null && index<data.size()) {
      if(data.get(index).isInteger()) {
        return true;
      } else {
        if(child==null) {
          child = new NestestIteratorPractise(data.get(index).getDataList());
        }
        if(child.hasNext()) {
          return true;
        } else {
          index++;
          child = null;
          return hasNext();
        }
      }
    }
    return false;
  }

  @Override public Integer next() {
    if(data.get(index).isInteger()) {
      return data.get(index++).getData();
    } else {
      child.next();
    }
    return null;
  }
}
