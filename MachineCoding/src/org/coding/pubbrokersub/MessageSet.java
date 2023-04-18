package org.coding.pubbrokersub;

import java.util.ArrayList;
import java.util.List;

public class MessageSet {
  private List<Message> messageList;

  public MessageSet() {
    this.messageList = new ArrayList<>();
  }

  public void addMessage(Message message) {
    this.messageList.add(message);
  }

  public List<Message> getMessageList() {
    return this.messageList;
  }
}
