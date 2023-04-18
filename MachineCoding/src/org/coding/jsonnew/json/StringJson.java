package org.coding.jsonnew.json;

public class StringJson implements Json<String>{
  private final String data;
  public StringJson(String data) {
    this.data = data;
  }
  @Override public String getData() {
    return data;
  }
}
