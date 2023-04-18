package com.flipkart.cabservice.command;

import com.flipkart.cabservice.Event;

public class RegisterEvent extends Event {
  private String driverName;
  private String cabNumber;
  private int phNumber;
  private String city;

  public RegisterEvent(String driverName, String cabNumber, int phNumber, String city) {
    this.driverName = driverName;
    this.cabNumber = cabNumber;
    this.phNumber = phNumber;
    this.city = city;
  }

  public String getDriverName() {
    return driverName;
  }

  public String getCabNumber() {
    return cabNumber;
  }

  public int getPhNumber() {
    return phNumber;
  }

  public String getCity() {
    return city;
  }
}
