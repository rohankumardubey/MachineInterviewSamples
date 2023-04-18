package org.apache.linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {

  public Link head;

  public void add(int data) {
    if (head == null) {
      head = new Link();
      head.data = data;
      return;
    }
    Link current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new Link();
    current.next.data = data;
  }

  public void delete(int data) {
    Link cuLink = head;
    if (cuLink.data == data) {
      head = head.next;
      return;
    }
    Link prv = head;
    cuLink = cuLink.next;
    while (cuLink != null) {
      if (cuLink.data == data) {
        prv.next = cuLink.next;
        break;
      }
      prv = cuLink;
      cuLink = cuLink.next;
    }
  }

  public void print(Link head) {
    if (head == null) {
      return;
    }
    Link current = head;
    while (current.next != null) {
      System.out.print(current.data + "->");
      current = current.next;
    }
    System.out.print(current.data);
    System.out.println();
  }

  public void print() {
    if (head == null) {
      return;
    }
    Link current = head;
    while (current.next != null) {
      System.out.print(current.data + "->");
      current = current.next;
    }
    System.out.print(current.data);
    System.out.println();
  }

  public int getMiddle() {
    Link slow = head;
    Link fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow.data;
  }

  public void reverseLinkedList() {
    Link current = head.next;
    Link reverse = head;
    reverse.next = null;
    while (current != null) {
      Link next = current;
      current = current.next;
      next.next = reverse;
      reverse = next;
    }
    head = reverse;
  }

  public Link reverseLinkedList(Link head) {
    Link current = head.next;
    Link reverse = head;
    reverse.next = null;
    while (current != null) {
      Link next = current;
      current = current.next;
      next.next = reverse;
      reverse = next;
    }
    return reverse;
  }

  public void rotate(int n) {
    if (n == 0) {
      return;
    }
    Link current = head.next;
    Link reverse = head;
    reverse.next = null;
    int counter = 1;
    while (current != null && counter < n) {
      Link next = current;
      current = current.next;
      next.next = reverse;
      reverse = next;
      counter++;
    }
    head = current;
    while (current.next != null) {
      current = current.next;
    }
    current.next = reverse;
  }

  public void reverseK(int k) {
    Link current = head;
    Stack<Link> stack = new Stack<>();
    int counter = 0;
    Link prv = null;
    while (current != null) {
      while (current != null && counter < k) {
        stack.push(current);
        current = current.next;
        counter++;
      }
      counter = 0;
      while (!stack.isEmpty()) {
        if (prv == null) {
          prv = stack.pop();
          head = prv;
          prv.next = null;
        } else {
          prv.next = stack.pop();
          prv = prv.next;
        }
      }
    }
    prv.next = null;
  }

  public boolean detectLoop() {
    createLoop();
    Link slow = head;
    Link fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;

  }

  public void removeLoop() {
    createLoop();
    Link slow = head;
    Link fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        fast.next = null;
      }
    }
  }

  private void createLoop() {
    Link current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = head.next.next.next;
  }

  public int nThNodeFromLast(int counter) {
    Link current = head;
    Link slow = head;
    int i = 0;
    while (i < counter) {
      if (current == null) {
        return -1;
      }
      current = current.next;
      i++;
    }
    while (current != null) {
      current = current.next;
      slow = slow.next;
    }
    return slow.data;
  }

  public void pairWiseSwapData() {
    Link current = head;
    while (current != null && current.next != null) {
      int temp = current.data;
      current.data = current.next.data;
      current.next.data = temp;
      current = current.next.next;
    }
  }

  public void pariWiseSwap() {
    Link current = head.next;
    Link prv = head;
    head = current;
    while (true) {
      Link n = current.next;
      current.next = prv;
      if (n == null || n.next == null) {
        prv.next = null;
        break;
      }
      prv.next = n.next;
      prv = n;
      current = prv.next;
    }
  }

  public Link mergeSortedList(Link first, Link second) {
    Link prv = null;
    Link finalOut = null;
    while (first != null && second != null) {
      if (first.data > second.data) {
        if (null == prv) {
          prv = second;
          finalOut = prv;
          second = second.next;
        } else {
          prv.next = second;
          prv = prv.next;
          second = second.next;
        }
      } else {
        if (null == prv) {
          prv = first;
          finalOut = prv;
          first = first.next;
        } else {
          prv.next = first;
          first = first.next;
          prv = prv.next;
        }
      }
    }
    if (first != null) {
      prv.next = first;
    } else if (second != null) {
      prv.next = second;
    }
    return finalOut;
  }

  public boolean checkPlindrom(Link head) {
    Link slow = head;
    Link fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    Link middle = slow;
    Link link;
    if (fast == null) {
      link = reverseLinkedList(slow);
    } else {
      link = reverseLinkedList(slow.next);
    }
    Link current = head;
    Link psrv = link;
    while (current != middle) {
      if (current.data != link.data) {
        return false;
      }
      current = current.next;
      link = link.next;
    }
    reverseLinkedList(psrv);
    return true;
  }

  public Link sortZeroOneTwo(Link head) {
    Link current = head;
    int zeroCount = 0;
    int oneCount = 0;
    while (current != null) {
      if (current.data == 0) {
        zeroCount++;
      } else if (current.data == 1) {
        oneCount++;
      }
      current = current.next;
    }
    int counter = 0;
    current = head;
    while (current != null && counter < zeroCount) {
      current.data = 0;
      current = current.next;
      counter++;
    }
    counter = 0;
    while (current != null && counter < oneCount) {
      current.data = 1;
      current = current.next;
      counter++;
    }
    while (current != null) {
      current.data = 2;
      current = current.next;
    }
    return head;
  }

  public long addTwoNumberRepresentingLinkedList(Link first, Link second) {
    String s = "";
    int c = 0;
    while (first != null && second != null) {
      int x = first.data + second.data + c;
      c = x / 10;
      int d = x % 10;
      s += d;
      first = first.next;
      second = second.next;
    }
    while (first != null) {
      int x = first.data + c;
      c = x / 10;
      int d = x % 10;
      s += d;
      first = first.next;
    }

    while (second != null) {
      int x = second.data + c;
      c = x / 10;
      int d = x % 10;
      s += d;
      second = second.next;
    }
    s += c;
    final char[] chars = s.toCharArray();
    char[] a = new char[chars.length];
    int counter = chars.length - 1;
    for (int i = 0; i < chars.length; i++) {
      a[counter] = chars[i];
      counter--;
    }
    return Long.parseLong(new String(a));
  }

  public int isIntersect(Link first, Link second) {
    Set<Link> set = new HashSet<>();
    while (first != null) {
      set.add(first);
      first = first.next;
    }

    while (second != null) {
      if (set.contains(second)) {
        return second.data;
      }
      second = second.next;
    }
    return -1;
  }

  public int isIntersectOne(Link first, Link second) {
    Link current = first;
    Link current1 = second;
    int firstListCount = 0;
    int secondListCount = 0;
    while (current != null) {
      firstListCount++;
      current = current.next;
    }
    while (current1 != null) {
      secondListCount++;
      current1 = current1.next;
    }

    int d = firstListCount > secondListCount ?
        firstListCount - secondListCount :
        secondListCount - firstListCount;
    if (firstListCount > secondListCount) {
      current = first;
      int counter = 0;
      while (current != null && counter < d) {
        counter++;
        current = current.next;
      }
      current1 = second;
    } else {
      current1 = first;
      int counter = 0;
      while (current1 != null && counter < d) {
        counter++;
        current1 = current1.next;
      }
      current = first;
    }

    while (current != null && current1 != null) {
      if (current == current1) {
        return current1.data;
      }
      current = current.next;
      current1 = current1.next;
    }
    return -1;
  }

  public void deleteWithoutHead(Link pointer) {
    final Link next = pointer.next;
    pointer.data = next.data;
    pointer.next = next.next;
  }

  public void printReverse(Link link) {
    if(null==link) {
      return;
    }
    System.out.println(link.data);
    printReverse(link.next);
  }

  public int lengthOfLinkedList(Link link) {
    if(link == null) {
      return 0;
    }
    return 1+lengthOfLinkedList(link.next);
  }

  public Link reverseRecursively(Link node) {
   Link newHead;
    if ((node.next == null)) {
      return node;
    }
    newHead = reverseRecursively(node.next);
    node.next.next = node;
    node.next = null;
    return newHead;
  }
}
