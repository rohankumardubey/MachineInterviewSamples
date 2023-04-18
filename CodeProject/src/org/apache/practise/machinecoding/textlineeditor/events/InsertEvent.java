package org.apache.practise.machinecoding.textlineeditor.events;

public class InsertEvent extends Event{
  private String line;
  private long lineNumber;

  public InsertEvent(String line, long lineNumber) {
    this.line = line;
    this.lineNumber = lineNumber;
  }

  public String getLine() {
    return line;
  }

  public long getLineNumber() {
    return lineNumber;
  }
}
