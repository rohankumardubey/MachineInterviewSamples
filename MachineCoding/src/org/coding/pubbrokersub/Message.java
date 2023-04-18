package org.coding.pubbrokersub;

public class Message {
  private byte[] payload;
  public Message(byte[] payload) {
    this.payload = payload;
  }
  public byte[] getPayload() {
    return payload;
  }
}
