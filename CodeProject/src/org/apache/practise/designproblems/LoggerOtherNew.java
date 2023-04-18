package org.apache.practise.designproblems;

import java.util.HashSet;

public class LoggerOtherNew {
  private int oldestMessage;
  private HashSet<String>[] message;
  public LoggerOtherNew() {
    this.message = new HashSet[10];
    for (int i = 0; i <10 ; i++) {
      this.message[i] = new HashSet<>();
    }
  }

  public boolean shouldPrint(String newMessage, int timestamp) {
    clearMessage(timestamp);
    final boolean b = searchMessage(newMessage);
    if(b) {
      message[timestamp%10].add(newMessage);
    }
    return b;
  }

  private boolean searchMessage(String newMessage) {
    for (int i = 0; i < message.length; i++) {
      if(message[i].contains(message)) {
        return false;
      }
    }
    return true;
  }
  private void clearMessage(int timestamp) {
    int newOldestTime = Math.max(0, timestamp-10+1);
    int clearCount = Math.min(10, (newOldestTime - oldestMessage));
    for (int i = 0; i < clearCount; i++) {
      message[(i+oldestMessage)%10].clear();
    }
    oldestMessage = newOldestTime;
  }
}
