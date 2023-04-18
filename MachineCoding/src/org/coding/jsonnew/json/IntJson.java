package org.coding.jsonnew.json;

public class IntJson implements Json<Integer>{
  private int data;
  public IntJson(int data) {
    this.data = data;
  }
  @Override public Integer getData() {
    return data;
  }
}
