package org.apache.practise.machinecoding.textlineeditor.events;

public class PasteEvent extends Event{
  private long lineNumber;

  public PasteEvent(long lineNumber) {
    this.lineNumber = lineNumber;
  }

  public long getLineNumber() {
    return lineNumber;
  }
}
