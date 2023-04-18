package com.flipkart.cabservice.command;

import com.flipkart.cabservice.Event;

public class BookingEvent extends Event {
  private String userName;
  private String source;
  private String dest;

  public BookingEvent(String userName, String source, String dest) {
    this.userName = userName;
    this.source = source;
    this.dest = dest;
  }

  public String getUserName() {
    return userName;
  }

  public String getSource() {
    return source;
  }

  public String getDest() {
    return dest;
  }
}
