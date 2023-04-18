package org.apache.practise.machinecoding.textlineeditor.events;

public abstract class Event {
  public String getEventType() {
    return this.getClass().getName();
  }
}
