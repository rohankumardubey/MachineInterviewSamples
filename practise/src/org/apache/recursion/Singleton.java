package org.apache.recursion;

public enum Singleton {
  INSTANCE;

  public Object getObject() {
    return new Object();
  }
}
