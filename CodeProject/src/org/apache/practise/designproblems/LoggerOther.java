package org.apache.practise.designproblems;

import java.util.HashSet;

public class LoggerOther {
  private int oldestMessage;
  private HashSet<String>[] messages;
  public LoggerOther() {
    oldestMessage = 0;
    messages = new HashSet[10];
    for (int i = 0; i < 10; i++)
      messages[i] = new HashSet<>();
  }

  public boolean shouldPrint(int timestamp, String message) {
    cleanArray(timestamp);
    boolean searchResult = searchMessage(message);
    if (searchResult) {
      messages[timestamp % 10].add(message);
    }
    return searchResult;
  }

  private boolean searchMessage(String msg) {
    for (int i = 0; i < 10; i++) {
      if (messages[i].contains(msg))
        return false;
    }
    return true;
  }

  private void cleanArray(int timestamp) {
    int newOldestMessage = Math.max(0, timestamp - 10 + 1);
    int maxClearCount = Math.min(10, (newOldestMessage - oldestMessage));
    for (int i = 0; i < maxClearCount; i++) {
      messages[(oldestMessage + i) % 10].clear();
    }
    oldestMessage = newOldestMessage;
  }
}
