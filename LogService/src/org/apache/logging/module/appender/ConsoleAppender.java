package org.apache.logging.module.appender;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.apache.logging.core.LogEvent;
import org.apache.logging.module.formatter.LogFormatter;

public class ConsoleAppender implements LogAppender {

  private LogFormatter logFormatter;

  public ConsoleAppender(LogFormatter logFormatter, String target) throws FileNotFoundException {
    this.logFormatter = logFormatter;
    if (null != target) {
      switch (target) {
        case "Sysout":
          System.setOut(new PrintStream("/home/root1/sysout.log"));
        case "SysError":
          System.setErr(new PrintStream("/home/root1/syserror.log"));
        default:
          System.setOut(new PrintStream("/home/root1/sysout.log"));
      }
    }
  }

  @Override public void appendLog(LogEvent event) {
    System.out.println(event.getFormattedMessage(logFormatter));
  }
}
