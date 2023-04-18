package org.apache.logging.module.formatter;

import java.text.SimpleDateFormat;

import org.apache.logging.util.LogProperties;
import org.apache.logging.util.LogConfig;

public abstract class AbstractFormatter implements LogFormatter {
  protected SimpleDateFormat simpleDateFormat;

  protected boolean isFqnEnabled;

  protected boolean showLevels;

  protected String seperator;

  public AbstractFormatter() {
    if (Boolean.parseBoolean(
        LogConfig.LOGGING_PROPERTIES.getProperties(LogProperties.ShowDATE, "true"))) {
      simpleDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss:SSS");
    }
    if (Boolean.parseBoolean(
        LogConfig.LOGGING_PROPERTIES.getProperties(LogProperties.ShowFQCN, "true"))) {
      isFqnEnabled = true;
    }
    if (Boolean.parseBoolean(
        LogConfig.LOGGING_PROPERTIES.getProperties(LogProperties.ShowLEVEL, "true"))) {
      showLevels = true;
    }
    seperator = LogConfig.LOGGING_PROPERTIES.getProperties(LogProperties.Separator, "|");
  }
}
