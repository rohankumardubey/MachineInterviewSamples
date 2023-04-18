package org.uber.parkinglot;

public class CostCalculator {
  public double getCost(long parkingDuration, double costFactor) {
    return parkingDuration * costFactor;
  }
}