package org.coding.textlineeditor.event;

public class CopyDeleteDisplayEvent extends Event {
  private int startLineNumber;
  private int endLineNumber;

  public CopyDeleteDisplayEvent(int startLineNumber, int endLineNumber) {
    this.startLineNumber = startLineNumber;
    this.endLineNumber = endLineNumber;
  }

  public int getStartLineNumber() {
    return startLineNumber;
  }

  public int getEndLineNumber() {
    return endLineNumber;
  }
}
