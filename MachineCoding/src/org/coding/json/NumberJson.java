package org.coding.json;

public class NumberJson implements Json<Integer> {
  private int number;
  public NumberJson(int number) {
    this.number = number;
  }

  @Override public Integer getData() {
    return number;
  }
}
