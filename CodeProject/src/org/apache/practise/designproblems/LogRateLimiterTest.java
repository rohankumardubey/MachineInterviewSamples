package org.apache.practise.designproblems;

public class LogRateLimiterTest {
  public static void main(String[] args) {
    LoggerOther loggerRateLimiter = new LoggerOther();
    System.out.println(loggerRateLimiter.shouldPrint(1, "vishal"));
    System.out.println(loggerRateLimiter.shouldPrint(2,"babu"));
    System.out.println(loggerRateLimiter.shouldPrint(10,"vis"));
//    System.out.println(loggerRateLimiter.shouldPrint(4, "chetan"));
    System.out.println(loggerRateLimiter.shouldPrint(11,"vishal"));
    System.out.println(loggerRateLimiter.shouldPrint(13, "babu"));
    System.out.println(loggerRateLimiter.shouldPrint(35, "chetan"));
  }
}
