package org.apache.practise.machinecoding.textlineeditor.storage.internalstorage.impl.linkedlist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.practise.machinecoding.textlineeditor.storage.internalstorage.DataStore;

public class LLStore implements DataStore {
  private Node head;
  private Map<Integer, Node> map;
  private Node tail;

  public LLStore() {
    head = new Node("head", Integer.MIN_VALUE);
    tail = new Node("tail", Integer.MAX_VALUE);
    head.setNext(tail);
    tail.setPrv(head);
    map = new HashMap<>();
  }

  @Override public void insert(int lineNumber, String line) {
    Node current = head;
    Node node = new Node(line, lineNumber);
    while (current != null && current.getLineNumber() < lineNumber) {
      current = current.getNext();
    }
    node.setNext(current);
    node.setPrv(current.getPrv());
    current.getPrv().setNext(node);
    current.setPrv(node);
    map.put(lineNumber, node);
  }

  @Override public String delete(int lineNumber) {
    final Node node = map.remove(lineNumber);
    if (node != null) {
      node.getPrv().setNext(node.getNext());
      node.getNext().setPrv(node.getPrv());
      return node.getLine();
    }
    return null;
  }

  @Override public String get(int lineNumber) {
    return map.get(lineNumber).getLine();
  }

  @Override public Iterator<String> getIterator() {
    return new DataIterator(head.getNext());
  }

  private class DataIterator implements Iterator<String> {
    private Node pointer;

    private DataIterator(Node pointer) {
      this.pointer = pointer.getNext();
    }

    @Override public boolean hasNext() {
      return pointer != tail;
    }

    @Override public String next() {
      final String line = pointer.getLine();
      pointer = pointer.getNext();
      return line;
    }
  }
}
