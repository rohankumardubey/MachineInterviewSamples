package org.apache.practise.designproblems;

import java.util.List;

public class TrieNodeRegex {

  private Trie trie;

  public TrieNodeRegex() {
    this.trie = new Trie();
  }

  public void add(String word) {
    Trie current = trie;
    for (int i = 0; i < word.length(); i++) {
      if (current.child == null) {
        current.child = new Trie[26];
      }
      int index = intToChar(word.charAt(i));
      if (current.child[index] == null) {
        current.child[index] = new Trie();
      }
      current = current.child[index];
    }
  }

  public void searchRegex(Trie t, int index, String searchString, List<String> list,
      StringBuilder stringBuilder) {
    if (t == null) {
      return;
    }
    if (t.isLeaf) {
      list.add(stringBuilder.toString());
      return;
    }
    final Trie[] child = t.child;
    if (null == child) {
      return;
    }
    for (int i = 0; i < child.length; i++) {
      if (child[i] == null) {
        continue;
      }
      if (index < searchString.length()) {

      } else {

      }
    }
  }

  private int intToChar(char a) {
    return a - 'a';
  }

  private class Trie {
    private boolean isLeaf;
    private Trie[] child;
  }
}
