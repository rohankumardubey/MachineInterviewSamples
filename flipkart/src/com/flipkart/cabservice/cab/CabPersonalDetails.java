package com.flipkart.cabservice.cab;

public class CabPersonalDetails {
  private String driverName;
  private String cabNumber;
  private int phNumber;

  public CabPersonalDetails(String driverName, String cabNumber, int phNumber) {
    this.driverName = driverName;
    this.cabNumber = cabNumber;
    this.phNumber = phNumber;
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
}
