package org.apache.logging.util;

import org.apache.logging.core.LogManager;
import org.apache.logging.core.Logger;

public class Test {
  public static void main(String[] args) {
    String s = "org.apache.class.name.vishalkumar.avani";
    final Logger logger = LogManager.getINSTANCE().getLogger(s);
    logger.debug("this is debug message");
    System.out.println("my log message");
    System.err.println("my error message");
  }
}
