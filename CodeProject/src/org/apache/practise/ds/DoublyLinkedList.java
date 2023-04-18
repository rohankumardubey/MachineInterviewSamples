package org.apache.practise.ds;

public class DoublyLinkedList {
  private Node head;
  private Node tail;

  public DoublyLinkedList() {

  }

  public void addLast(int data) {
    if (head == null) {
      head = new Node(data);
      tail = head;
      return;
    }
    Node n = new Node(data);
    n.prv = tail;
    tail.next = n;
    tail = n;
  }

  public void addFirst(int data) {
    if (head == null) {
      head = new Node(data);
      tail = head;
      return;
    }

    Node n = new Node(data);
    n.next = head;
    head.prv = n;
    head = n;
  }

  public void removeFirst() {
    if (head == null) {
      return;
    }
    head = head.next;
    head.prv = null;
  }

  public void removeLast() {
    if (tail == null) {
      return;
    }
    tail = tail.prv;
    tail.next = null;
  }

  public static void main(String[] args) {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.addLast(1);
    doublyLinkedList.addLast(2);
    doublyLinkedList.addLast(3);
    doublyLinkedList.addLast(4);
    doublyLinkedList.remove(1);
  }

  public void remove(int data) {
    if (head == null) {
      return;
    }
    Node current = head;
    while (current != null) {
      if (current.data == data) {
        break;
      }
      current = current.next;
    }
    if (null != current) {
      if (current == head) {
        head = head.next;
        head.prv = null;
      } else if (current == tail) {
        tail = tail.prv;
        tail.next = null;
      } else {
        current.prv.next = current.next;
        current.next.prv = current.prv;
      }
    }
    System.out.println();
  }

  private class Node {
    private int data;

    private Node(int data) {
      this.data = data;
    }

    private Node next;
    private Node prv;
  }
}
