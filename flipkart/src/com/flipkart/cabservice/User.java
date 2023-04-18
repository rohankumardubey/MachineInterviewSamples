package com.flipkart.cabservice;

import java.util.Objects;

public class User {
  private String userName;
  private String sourceCity;
  private String destinationCity;

  public User(String userName, String sourceCity, String destinationCity) {
    this.userName = userName;
    this.sourceCity = sourceCity;
    this.destinationCity= destinationCity;
  }

  public String getSourceCity() {
    return sourceCity;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(userName, user.userName);
  }

  @Override public int hashCode() {

    return Objects.hash(userName);
  }
}
