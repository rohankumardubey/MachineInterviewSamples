package org.coding.json;

public class StringJson implements Json<String>{
  private String data;
  public StringJson(String data) {
    this.data = data;
  }

  @Override public String getData() {
    return data;
  }
}
