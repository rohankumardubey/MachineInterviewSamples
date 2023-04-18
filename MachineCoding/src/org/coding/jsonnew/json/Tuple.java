package org.coding.jsonnew.json;

public class Tuple {
  private String key;
  private Json value;
  public Tuple(String key, Json value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }
  public Json getValue() {
    return value;
  }
}
