package org.apache.practise.machinecoding.autocompletesystem;

import java.util.PriorityQueue;
import java.util.Queue;

public class TrieNode {
  private Trie trie;

  public TrieNode() {
    this.trie = new Trie();
  }

  public void insert(String sentence, int numberOfTimes) {
    Trie current = trie;
    for (int i = 0; i < sentence.length(); i++) {
      if (!current.hasChid()) {
        current.createChid();
      }
      if (null == current.getChild()[int_(sentence.charAt(i))]) {
        current.getChild()[int_(sentence.charAt(i))] = new Trie();
      }
      current = current.getChild()[int_(sentence.charAt(i))];
    }
    current.setNumberOfTimes(numberOfTimes);
  }

  public Queue<Node> searchTop(String s) {
    Queue<Node> queue = new PriorityQueue<>(3);
    StringBuilder stringBuilder = new StringBuilder();
    searchTop(s, queue, 0, trie, stringBuilder);
    return queue;
  }

  private void searchTop(String s, Queue<Node> queue, int index, Trie trie,
      StringBuilder stringBuilder) {
    if (null == trie) {
      return;
    }
    if (trie.getNumberOfTimes() > 0) {
      queue.add(new Node(stringBuilder.toString(), trie.getNumberOfTimes()));
    }
    final Trie[] child = trie.getChild();
    if (null == child) {
      return;
    }
    for (int i = 0; i < child.length; i++) {
      if (child[i] != null) {
        if (index >= s.length()) {
          stringBuilder.append(char_(i));
          searchTop(s, queue, index, child[i], stringBuilder);
          stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else {
          if (i == int_(s.charAt(index))) {
            stringBuilder.append(s.charAt(index));
            searchTop(s, queue, ++index, child[i], stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
          }
        }
      }
    }
  }

  private int int_(char c) {
    return c == ' ' ? 26 : c - 'a';
  }

  private char char_(int i) {
    return i == 26 ? ' ' : (char) ('a' + i);
  }
}
