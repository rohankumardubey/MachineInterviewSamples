package com.flipkart.cabservice.command;

import com.flipkart.cabservice.Event;

public class EndBookingEvent extends Event {
  private String userName;
  public EndBookingEvent(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }
}
