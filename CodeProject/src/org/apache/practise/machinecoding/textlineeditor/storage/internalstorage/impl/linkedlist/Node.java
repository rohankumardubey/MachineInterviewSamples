package org.apache.practise.machinecoding.textlineeditor.storage.internalstorage.impl.linkedlist;

public class Node {
  private String line;
  private Node next;
  private int lineNumber = -1;
  private Node prv;
  public Node(String line, int lineNumber) {
    this.line = line;
    this.lineNumber = lineNumber;
  }

  public String getLine() {
    return line;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(int lineNumber) {
    this.lineNumber = lineNumber;
  }

  public Node getPrv() {
    return prv;
  }

  public void setPrv(Node prv) {
    this.prv = prv;
  }
}
