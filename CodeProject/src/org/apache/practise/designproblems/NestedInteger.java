package org.apache.practise.designproblems;

import java.util.List;

public class NestedInteger {
  private int data;
  private List<NestedInteger> dataList;

  public boolean isInteger() {
    return dataList==null;
  }

  public int getData() {
    return data;
  }

  public List<NestedInteger> getDataList() {
    return dataList;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void setDataList(List<NestedInteger> dataList) {
    this.dataList = dataList;
  }
}
