package org.coding.jsonnew.json;

public class JsonRawString {
  private String data;
  private int offset;
  private char DOUBLE_QUOTE = '\"';
  private JsonRawString(String data) {
    this.data = data;
  }

  public void skipWhiteSpace() {
    while (Character.isWhitespace(data.charAt(offset))) {
      offset++;
    }
  }

  public boolean isDigit() {
    return Character.isDigit(data.charAt(offset));
  }

  public boolean isChar(char c) {
    return data.charAt(offset) == c;
  }

  public String getString() {
    int start = offset;
    offset++;
    while (data.charAt(offset) != DOUBLE_QUOTE) {
      offset++;
    }
    offset++;
    return data.substring(start + 1, offset - 1);
  }

  public int getNumber() {
    int start = offset;
    while (Character.isDigit(data.charAt(offset))) {
      offset++;
    }
    return Integer.parseInt(data.substring(start, offset));
  }

  public void skipChar() {
    offset++;
  }

}
