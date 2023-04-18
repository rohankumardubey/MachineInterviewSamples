package org.apache.practise.designproblems;

import java.util.ArrayList;
import java.util.List;

public class Trie {
  private TrieNode trieNode;

  public Trie() {
    trieNode = new TrieNode();
  }

  public boolean startsWith(String word) {
    return getLeaf(word) != null;
  }

  private TrieNode getLeaf(String word) {
    final char[] chars = word.toCharArray();
    TrieNode[] temp = this.trieNode.getChild();
    for (int i = 0; i < chars.length - 1; i++) {
      int index = chars[i] - 97;
      if (temp[index] == null) {
        return null;
      }
      temp = temp[index].getChild();
    }
    int index = chars[chars.length - 1] - 97;
    if (temp[index] == null) {
      return null;
    }
    return temp[index];
  }

  public boolean search(String word) {
    final TrieNode leaf = getLeaf(word);
    if (leaf == null) {
      return false;
    }
    return leaf.isLeaf();
  }

  public void addWord(String word) {
    if (!trieNode.hasChildren()) {
      trieNode.createChild();
    }
    TrieNode[] temp = this.trieNode.getChild();
    for (int i = 0; i < word.length() - 1; i++) {
      int index = word.charAt(i) - 97;
      if (temp[index] == null) {
        temp[index] = new TrieNode();
      }
      if (!temp[index].hasChildren()) {
        temp[index].createChild();
      }
      temp = temp[index].getChild();
    }
    int index = word.charAt(word.length() - 1) - 97;
    if (temp[index] == null) {
      temp[index] = new TrieNode();
    }
    temp[index].setKey(word);
    temp[index].setIsLeaf();
  }

  public List<String> getAllKey() {
    List<String> strings = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    getAllKey(trieNode, strings, builder);
    return strings;
  }

  private void getAllKey(TrieNode trieNode, List<String> strings, StringBuilder stringBuilder) {
    if (trieNode == null) {
      return;
    }
    if (trieNode.isLeaf) {
      strings.add(stringBuilder.toString());
    }
    final TrieNode[] child = trieNode.getChild();
    if (null == child) {
      return;
    }
    for (int i = 0; i < child.length; i++) {
      if (child[i] != null) {
        char a = (char) (97 + i);
        stringBuilder.append(a);
        getAllKey(child[i], strings, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      }
    }
  }

  private class TrieNode {
    private TrieNode[] trieNode;
    private boolean isLeaf;
    private String key;

    private boolean isLeaf() {
      return isLeaf;
    }

    private void setIsLeaf() {
      isLeaf = true;
    }

    private boolean hasChildren() {
      return null != trieNode;
    }

    private TrieNode[] getChild() {
      return this.trieNode;
    }

    private void createChild() {
      trieNode = new TrieNode[26];
    }

    private String getKey() {
      return key;
    }

    private void setKey(String key) {
      this.key = key;
    }
  }
}
