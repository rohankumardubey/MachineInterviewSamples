package org.apache.practise.designproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOOneDataStructure {
  private Map<String, Node> keyToFrequencyNodeMap;
  private Node head;
  private Node tail;

  public AllOOneDataStructure() {
    keyToFrequencyNodeMap = new HashMap<>();
    head = new Node(-1);
    tail = new Node(-1);
    head.next = tail;
    tail.prv = head;
  }

  public void inc(String key) {
    Node node = keyToFrequencyNodeMap.get(key);
    Node updatedNode;
    if (null != node) {
      node.keys.remove(key);
      if (node.next.frequency == node.frequency + 1) {
        updatedNode = node.next;
        updatedNode.keys.add(key);
        if (node.keys.size() == 0) {
          updatedNode.prv = node.prv;
          node.prv.next = updatedNode;
        }
      } else {
        updatedNode = new Node(node.frequency + 1);
        updatedNode.keys.add(key);
        if (node.keys.size() == 0) {
          removeAndAdd(updatedNode, node);
        } else {
          appendNode(updatedNode, node);
        }
      }
    } else {
      if (head.next.frequency == 1) {
        updatedNode = head.next;
      } else {
        updatedNode = new Node(1);
        appendNode(updatedNode, head);
      }
      updatedNode.keys.add(key);
    }
    keyToFrequencyNodeMap.put(key, updatedNode);
  }

  private void appendNode(Node newNode, Node existingNode) {
    newNode.next = existingNode.next;
    existingNode.next.prv = newNode;
    existingNode.next = newNode;
    newNode.prv = existingNode;
  }

  private void removeAndAdd(Node newNode, Node existingNode) {
    newNode.next = existingNode.next;
    existingNode.next.prv = newNode;
    existingNode.prv.next = newNode;
    newNode.prv = existingNode.prv;
  }

  public void validate() {
    Node current  = head;
    while(current!=null) {
      current=current.next;
    }
    current = tail;
    while(current!=null) {
      current = current.prv;
    }
  }
  public void dec(String key) {
    final Node node = keyToFrequencyNodeMap.remove(key);
    if (node != null) {
      node.keys.remove(key);
      if (node.frequency == 1 && node.keys.size() == 0) {
        head.next = node.next;
        node.next.prv = head;
        return;
      } else {
        Node updatedNode;
        if (node.frequency - 1 == node.prv.frequency) {
          updatedNode = node.prv;
          if (node.keys.size() == 0) {
            node.prv.next = node.next;
            node.next.prv = node.prv;
          }
        } else {
          updatedNode = new Node(node.frequency - 1);
          if(node.keys.size()==0) {
            node.prv.next = updatedNode;
            updatedNode.next = node.next;
            node.next.prv = updatedNode;
            updatedNode.prv = node.prv;
          } else {
            updatedNode.prv = node.prv;
            node.prv.next = updatedNode;
            node.prv = updatedNode;
            updatedNode.next = node;
          }
        }
        updatedNode.keys.add(key);
        keyToFrequencyNodeMap.put(key, updatedNode);
      }
    }
  }

  public String getMaxKey() {
    return head.next == tail ? "" : tail.prv.keys.iterator().next();
  }

  public String getMinKey() {
    return head.next == tail ? "" : head.next.keys.iterator().next();
  }

  private class Node {
    private int frequency;
    private Set<String> keys;
    private Node next;
    private Node prv;

    private Node(int frequency) {
      this.frequency = frequency;
      this.keys = new HashSet<>();
    }
  }
}
