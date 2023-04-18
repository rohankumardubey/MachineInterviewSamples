package org.apache.practise.machinecoding.textlineeditor.storage.checkpoint;

public class Momento {
  private String line;
  private int lineNumber;

  public Momento(String line, int lineNumber) {
    this.line = line;
    this.lineNumber = lineNumber;
  }

  public String getLine() {
    return line;
  }

  public int getLineNumber() {
    return lineNumber;
  }
}
