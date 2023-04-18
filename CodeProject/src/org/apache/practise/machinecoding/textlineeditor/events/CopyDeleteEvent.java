package org.apache.practise.machinecoding.textlineeditor.events;

public class CopyDeleteEvent extends Event{
  private int start;
  private int end;
  public CopyDeleteEvent(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }
}
