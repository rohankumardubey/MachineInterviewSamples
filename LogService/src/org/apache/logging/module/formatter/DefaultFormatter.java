package org.apache.logging.module.formatter;

public class DefaultFormatter extends AbstractFormatter {

  @Override
  public String formatLogMessage(String className, String message, String level, Throwable t) {
    StringBuilder stringBuilder = new StringBuilder();
    if (null != simpleDateFormat) {
      stringBuilder.append(String
          .format("%-5s %1s", simpleDateFormat.format(System.currentTimeMillis()), seperator));
    }
    if (isFqnEnabled) {
      stringBuilder.append(String.format(" %-5s %5s", className, seperator));
    }

    if (showLevels) {
      stringBuilder.append(String.format(" %-5s %1s", level, seperator));
    }

    if (null != message) {
      stringBuilder.append(String.format(" %-6s%n", message));
    }
    if (null != t) {
      stringBuilder.append(String.format(" %-6s%n", t.toString()));
    }
    return stringBuilder.toString();
  }
}
