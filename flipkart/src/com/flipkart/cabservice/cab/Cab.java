package com.flipkart.cabservice.cab;

public class Cab {
  private CabPersonalDetails cabPersonalDetails;
  private CabState cabState;
  public Cab(CabPersonalDetails cabPersonalDetails) {
    this.cabPersonalDetails = cabPersonalDetails;
  }

  public void setCabState(CabState cabState) {
    this.cabState = cabState;
  }
}
