package org.apache.logging.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.module.appender.LogAppender;
import org.apache.logging.module.formatter.LogFormatter;
import org.apache.logging.util.LogProperties;
import org.apache.logging.util.LogConfig;

public class LogManager {

  private static LogManager INSTANCE;
  private final List<LogAppender> logAppenders;
  private final LogLevel defaultLogLevel;

  private LogManager() {
    defaultLogLevel = LogLevel.valueOf(
        LogConfig.LOGGING_PROPERTIES.getProperties(LogProperties.ROOT_LEVEL, LogLevel.DEBUG.name()));
    String handlerClassString = LogConfig.LOGGING_PROPERTIES
        .getProperties(LogProperties.Handler_CLASS,
            "org.apache.logging.module.appender.FileAppender");
    String formatterClassString = LogConfig.LOGGING_PROPERTIES
        .getProperties(LogProperties.FORMATTER_CLASS,
            "org.apache.logging.module.formatter.DefaultFormatter");
    final Object formatterClass = initializeClass(formatterClassString);
    logAppenders = new ArrayList<>();
    if(null!=formatterClass) {
      final String[] split = handlerClassString.split(",");
      for (int i = 0; i < split.length; i++) {
        final LogAppender logAppender =
            (LogAppender) initializeClass(split[i], new Object[] { formatterClass });
        if (null != logAppender) {
          logAppenders.add(logAppender);
        }
      }
      initializeClass1("org.apache.logging.module.appender.ConsoleAppender",
          new Object[] { formatterClass, "Sysout" });
      initializeClass1("org.apache.logging.module.appender.ConsoleAppender",
          new Object[] { formatterClass, "SysError" });
    }
  }

  public static LogManager getINSTANCE() {
    if (null == INSTANCE) {
      synchronized (LogManager.class) {
        if (null == INSTANCE) {
          INSTANCE = new LogManager();
        }
      }
    }
    return INSTANCE;
  }

  public Logger getLogger(String fqcn) {
    return new LoggerImpl(fqcn, defaultLogLevel, logAppenders);
  }

  private Object initializeClass(String className) {
    ClassLoader classLoader = this.getClass().getClassLoader();
    try {
      Class loadedMyClass = classLoader.loadClass(className);
      Constructor constructor = loadedMyClass.getConstructor();
      return constructor.newInstance();
    } catch (ClassNotFoundException e) {
      return null;
    } catch (NoSuchMethodException e) {
      return null;
    } catch (InstantiationException e) {
      return null;
    } catch (IllegalAccessException e) {
      return null;
    } catch (InvocationTargetException e) {
      return null;
    }
  }

  private Object initializeClass(String className, Object[] arg) {
    ClassLoader classLoader = this.getClass().getClassLoader();
    try {
      Class loadedMyClass = classLoader.loadClass(className);
      Constructor constructor = loadedMyClass.getConstructor(LogFormatter.class);
      return constructor.newInstance(arg);
    } catch (ClassNotFoundException e) {
      return null;
    } catch (NoSuchMethodException e) {
      return null;
    } catch (InstantiationException e) {
      return null;
    } catch (IllegalAccessException e) {
      return null;
    } catch (InvocationTargetException e) {
      return null;
    }
  }

  private Object initializeClass1(String className, Object[] arg) {
    ClassLoader classLoader = this.getClass().getClassLoader();
    try {
      Class loadedMyClass = classLoader.loadClass(className);
      Constructor constructor = loadedMyClass.getConstructor(LogFormatter.class, String.class);
      return constructor.newInstance(arg);
    } catch (ClassNotFoundException e) {
      return null;
    } catch (NoSuchMethodException e) {
      return null;
    } catch (InstantiationException e) {
      return null;
    } catch (IllegalAccessException e) {
      return null;
    } catch (InvocationTargetException e) {
      return null;
    }
  }
}
