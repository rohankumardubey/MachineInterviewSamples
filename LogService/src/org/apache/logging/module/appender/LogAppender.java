package org.apache.logging.module.appender;

import org.apache.logging.core.LogEvent;

public interface LogAppender {
  void appendLog(LogEvent event);
}
