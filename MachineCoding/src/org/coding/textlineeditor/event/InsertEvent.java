package org.coding.textlineeditor.event;

public class InsertEvent extends Event{
  private int lineNumber;
  private String line;

  public InsertEvent(int lineNumber, String line) {
    this.lineNumber = lineNumber;
    this.line = line;
  }

  public String getLine() {
    return line;
  }

  public int getLineNumber() {
    return lineNumber;
  }
}
