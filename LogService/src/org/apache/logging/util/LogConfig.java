package org.apache.logging.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public enum LogConfig {
  LOGGING_PROPERTIES;
  private static Properties properties;
  private static final String propertiesFilePath= "";

  private void loadProperties() throws IOException {
    if(null==properties) {
      synchronized (LogConfig.class) {
        if(null== properties) {
          properties = new Properties();
          File file = new File(propertiesFilePath);
          if(file.exists()) {
            properties.load(new FileReader(propertiesFilePath));
          }
        }
      }
    }
  }

  public String getProperties(LogProperties property) {
    try {
      loadProperties();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties.getProperty(property.name());
  }

  public String getProperties(LogProperties property, String defaultValue) {
    try {
      loadProperties();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String property1 = properties.getProperty(property.name());
    if(null == property1) {
      property1 = defaultValue;
      properties.setProperty(property.name(), property1);
    }
    return property1;
  }
}
