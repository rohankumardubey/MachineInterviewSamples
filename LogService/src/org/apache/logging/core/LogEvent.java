package org.apache.logging.core;

import java.io.Serializable;

import org.apache.logging.module.formatter.LogFormatter;

public class LogEvent implements Serializable {
  private String fqcn;
  private String message;
  private Throwable t;
  private LogLevel logLevel;
  public LogEvent(String fqcn, String message, Throwable t, LogLevel logLevel) {
    this.fqcn = fqcn;
    this.message = message;
    this.t = t;
    this.logLevel = logLevel;
  }

  public String getFormattedMessage(LogFormatter logFormatter) {
    return logFormatter.formatLogMessage(fqcn, message, logLevel.name(), t);
  }
}
