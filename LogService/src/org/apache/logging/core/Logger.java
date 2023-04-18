package org.apache.logging.core;

public interface Logger {
  void warn(String message);
  void info(String message);
  void debug(String message);
  void error(String message);
  void error(String message, Throwable t);
}
