package com.flipkart.cabservice;

public abstract class Event {
  public String getEventType() {
    return this.getClass().getName();
  }
}
