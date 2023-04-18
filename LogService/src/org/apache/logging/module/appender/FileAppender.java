package org.apache.logging.module.appender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.core.LogEvent;
import org.apache.logging.module.formatter.LogFormatter;
import org.apache.logging.util.LogConfig;
import org.apache.logging.util.LogProperties;

public class FileAppender implements LogAppender{

  private LogFormatter formatter;

  private BufferedWriter writer;

  private long maxFileSize;

  private String filePath;

  private long currentSize;

  public FileAppender(LogFormatter logFormatter) throws IOException {
    this.formatter = logFormatter;
    this.filePath = LogConfig.LOGGING_PROPERTIES
        .getProperties(LogProperties.FILEPATH, "/home/root1/vishal.log");
    try {
      maxFileSize = Long.parseLong(LogConfig.LOGGING_PROPERTIES
          .getProperties(LogProperties.MAX_FILE_SIZE, 10 * 1024 * 1024 + ""));
    } catch (NumberFormatException e) {
      maxFileSize = 10 * 1024 * 1024;
    }
    initializeWriter();
  }

  private void initializeWriter() throws IOException {
    File file = new File(filePath);
    if(file.exists()) {
      file.renameTo(new File(filePath+"_" + System.currentTimeMillis()));
    }
    this.writer = new BufferedWriter(new FileWriter(filePath, true));
    this.currentSize = 0;
  }

  @Override public void appendLog(LogEvent event) {
    if(currentSize >= maxFileSize) {
      try {
        initializeWriter();
      } catch (IOException e) {
        return;
      }
    }
    try {
      writer.write(event.getFormattedMessage(formatter));
    } catch (IOException e) {
      return;
    }
    try {
      writer.flush();
    } catch (IOException e) {
      return;
    }
  }
}
