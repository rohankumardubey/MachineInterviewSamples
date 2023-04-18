package org.apache.logging.module.formatter;

public interface LogFormatter {
  String formatLogMessage(String fqcn, String message, String level, Throwable t);
}
