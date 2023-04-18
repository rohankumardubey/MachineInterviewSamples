package org.apache.logging.core;

import java.util.List;

import org.apache.logging.module.appender.LogAppender;

public class LoggerImpl implements Logger {
  private final List<LogAppender> logAppenders;
  private String fqcn;
  private LogLevel logLevel;

  public LoggerImpl(String fqcn, LogLevel logLevel, List<LogAppender> logAppenders) {
    this.fqcn = fqcn;
    this.logLevel = logLevel;
    this.logAppenders = logAppenders;
  }

  @Override public void warn(String message) {
    if (LogLevel.WARN.ordinal() <= logLevel.ordinal()) {
      for (int i = 0; i < logAppenders.size(); i++) {
        final LogAppender logAppender = this.logAppenders.get(i);
        synchronized (logAppender) {
          logAppender.appendLog(new LogEvent(fqcn, message, null, LogLevel.WARN));
        }
      }
    }
  }

  @Override public void info(String message) {
    if (LogLevel.INFO.ordinal() <= logLevel.ordinal()) {
      for (int i = 0; i < logAppenders.size(); i++) {
        final LogAppender logAppender = this.logAppenders.get(i);
        synchronized (logAppender) {
          logAppender.appendLog(new LogEvent(fqcn, message, null, LogLevel.INFO));
        }
      }
    }
  }

  @Override public void error(String message) {
    if (LogLevel.ERROR.ordinal() <= logLevel.ordinal()) {
      for (int i = 0; i < logAppenders.size(); i++) {
        final LogAppender logAppender = this.logAppenders.get(i);
        synchronized (logAppender) {
          logAppender.appendLog(new LogEvent(fqcn, message, null, LogLevel.ERROR));
        }
      }
    }
  }

  @Override public void error(String message, Throwable t) {
    if (LogLevel.ERROR.ordinal() <= logLevel.ordinal()) {
      for (int i = 0; i < logAppenders.size(); i++) {
        final LogAppender logAppender = this.logAppenders.get(i);
        synchronized (logAppender) {
          logAppender.appendLog(new LogEvent(fqcn, message, null, LogLevel.ERROR));
        }
      }
    }
  }

  @Override public void debug(String message) {
    if (LogLevel.DEBUG.ordinal() <= logLevel.ordinal()) {
      for (int i = 0; i < logAppenders.size(); i++) {
        final LogAppender logAppender = this.logAppenders.get(i);
        synchronized (logAppender) {
          logAppender.appendLog(new LogEvent(fqcn, message, null, LogLevel.DEBUG));
        }
      }
    }
  }
}
