package org.apache.practise;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class LinkedList {
  private Link link;

  public void add(int number) {
    if (link == null) {
      link = new Link();
      link.data = number;
      return;
    }
    Link current = link;
    while (current.next != null) {
      current = current.next;
    }
    Link l = new Link();
    l.data = number;
    current.next = l;
  }

  public Link reverseLinkedList(Link l) {
    Link current = l.next;
    Link prv = l;
    prv.next = null;
    while (current != null) {
      Link x = current;
      current = current.next;
      x.next = prv;
      prv = x;
    }
    return prv;
  }

  private Link reverseRecursively(Link node) {
    Link newHead;
    if ((node.next == null)) {
      return node;
    }
    newHead = reverseRecursively(node.next);
    node.next.next = node;
    node.next = null;
    return newHead;
  }

  private Link getMiddle(Link link) {
    Link current = link;
    Link slow = link;
    while(current!=null && current.next!=null) {
      current = current.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private void deleteOne(int data) {
    if(link==null) {
      return;
    }
    if(link.data ==data) {
      link = link.next;
      return;
    }
    Link current = link.next;
    Link prv = link;
    while(current!=null) {
      if(current.data==data) {
        prv.next = current.next;
        break;
      }
      prv = current;
      current = current.next;
    }
  }


  private Link intersectPoint(Link first, Link second) {
    Set<Link> stack = new HashSet<>();
    while(first!=null) {
      stack.add(first);
      first=first.next;
    }
    while(second!=null) {
      if(stack.contains(second)) {
        return second;
      }
      second = second.next;
    }
    return null;
  }

  private boolean isPalindrom(Link link) {
    Link current = link.next;
    Link slow = link;
    while(current!=null && current.next!=null) {
      current = current.next;
      slow = slow.next;
    }
    Link reverse = slow;
    reverse = reverse(reverse);
    current = link;
    return false;
  }

  private Link reverse(Link link) {
    Link newHead;
    if(link.next==null) {
      return link;
    }
    newHead = reverse(link);
    link.next.next = link;
    link.next = null;
    return newHead;
  }

  public static void main(String[] args) {
    TreeMap<Integer, Integer> a= new TreeMap<>();
    a.put(1,null);
    a.put(3,null);
    a.put(2,null);
    System.out.println(a.firstKey());
    System.out.println(a.lastKey());

  }
}
