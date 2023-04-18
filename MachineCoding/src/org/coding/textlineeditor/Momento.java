package org.coding.textlineeditor;

public class Momento {
  private int lineNumber;
  private String line;

  public Momento(int lineNumber, String line) {
    this.lineNumber = lineNumber;
    this.line = line;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public String getLine() {
    return line;
  }
}
