package org.coding.textlineeditor.event;

public abstract class Event {
  public String getEventType() {
    return this.getClass().getName();
  }
}
