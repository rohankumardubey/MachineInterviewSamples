package org.apache.practise.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOneDS {
  private class Node {
    private Node(String nodeName) {
      this.nodeName = nodeName;
    }

    private Node() {
    }

    private String nodeName;
    private Set<String> keys = new HashSet<>();
    private int frequency = -1;
    private Node next;
    private Node prv;
  }

  private Map<String, Node> map;
  private Node head;
  private Node tail;

  public AllOneDS() {
    this.map = new HashMap<>();
    this.head = new Node("head");
    this.tail = new Node("tail");
    this.head.next = tail;
    this.tail.prv = head;
  }

  public static void main(String[] args) {
    AllOneDS allOneDS = new AllOneDS();
    allOneDS.insert("vishal");
    allOneDS.insert("vishal");
    allOneDS.insert("vishal");
    allOneDS.insert("vikas");
    //    allOneDS.insert("shivangi");
    allOneDS.insert("vikas");
    allOneDS.remove("vishal");
    allOneDS.remove("vishal");
    allOneDS.remove("vishal");

    //    System.out.println(allOneDS.mostFrequent());
  }

  public void remove(String data) {
    final Node node = map.get(data);
    if (null != node) {
      node.keys.remove(data);
      if (node.frequency == 1) {
        if (node.keys.size() == 0) {
          head.next = node.next;
          node.next.prv = head;
        }
        map.remove(data);
      } else {
        if (node.frequency - 1 == node.prv.frequency) {
          node.prv.keys.add(data);
          if (node.keys.size() == 0) {
            node.prv.next = node.next;
            node.next.prv = node.prv;
          }
          map.put(data, node.prv);
        } else {
          Node newNode = new Node();
          newNode.frequency = node.frequency - 1;
          newNode.keys.add(data);
          map.put(data, newNode);
          if (node.keys.size() == 0) {
            newNode.next = node.next;
            node.next.prv = newNode;
          } else {
            node.prv.next = newNode;
            newNode.prv = node.prv;
            newNode.next = node;
            node.prv = newNode;
          }
        }
      }
    }
  }

  public String mostFrequent() {
    return tail.prv.frequency == -1 ? "" : tail.prv.keys.iterator().next();
  }

  public void insert(String data) {
    final Node node = map.get(data);
    if (null != node) {
      node.keys.remove(data);
      if (node.next.frequency == node.frequency + 1) {
        node.next.keys.add(data);
        if (node.keys.size() == 0) {
          node.prv.next = node.next;
          node.next.prv = node.prv;
        }
        map.put(data, node.next);
      } else {
        Node newNode = new Node();
        newNode.frequency = node.frequency + 1;
        newNode.keys.add(data);
        if (node.keys.size() == 0) {
          newNode.next = node.next;
          node.next.prv = newNode;
          newNode.prv = node.prv;
          node.prv.next = newNode;
        } else {
          newNode.next = node.next;
          node.next.prv = newNode;
          node.next = newNode;
          newNode.prv = node;
        }
        map.put(data, newNode);
      }
    } else {
      if (head.next.frequency == 1) {
        head.next.keys.add(data);
        map.put(data, head.next);
      } else {
        Node newNode = new Node();
        newNode.frequency = 1;
        newNode.keys.add(data);
        newNode.next = head.next;
        head.next.prv = newNode;
        head.next = newNode;
        newNode.prv = head;
        map.put(data, newNode);
      }
    }
  }
}
