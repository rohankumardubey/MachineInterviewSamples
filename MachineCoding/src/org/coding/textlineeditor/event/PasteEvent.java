package org.coding.textlineeditor.event;

public class PasteEvent extends Event{
  private int lineNumber;

  public PasteEvent(int lineNumber) {
    this.lineNumber = lineNumber;
  }

  public int getLineNumber() {
    return lineNumber;
  }
}
