package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
  private int len;
  private Map<String, List<String>> allComboDict;

  public WordLadder() {
    this.allComboDict = new HashMap<>();
  }

  public int ladderLength(String startWord, String endWord, List<String> dict) {
    if (null == dict || !dict.contains(endWord)) {
      return 0;
    }
    len = startWord.length();
    for (int i = 0; i < dict.size(); i++) {
      for (int j = 0; j < len; j++) {
        String newWord = startWord.substring(0, i) + "*" + startWord.substring(i + 1, len);
        final List<String> orDefault = allComboDict.getOrDefault(newWord, new ArrayList<>());
        orDefault.add(dict.get(i));
        this.allComboDict.put(newWord, orDefault);
      }
    }

    Queue<Pair<String, Integer>> queue = new LinkedList<>();
    queue.add(new Pair<>(startWord, 1));
    Map<String, Boolean> visitedNode = new HashMap<>();
    visitedNode.put(startWord, true);
    while (!queue.isEmpty()) {
      final Pair<String, Integer> poll = queue.poll();
      String currentWord = poll.key;
      int level = poll.value;
      for (int i = 0; i < len; i++) {
        String newWord = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, len);
        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
          if (adjacentWord.equals(endWord)) {
            return level + 1;
          }
          if (!visitedNode.containsKey(adjacentWord)) {
            visitedNode.put(adjacentWord, true);
            queue.add(new Pair<>(adjacentWord, level + 1));
          }
        }
      }
    }
    return 0;
  }

  private class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public boolean equals(Object var1) {
      if (this == var1) {
        return true;
      } else if (!(var1 instanceof Pair)) {
        return false;
      } else {
        Pair var2 = (Pair) var1;
        if (this.key != null) {
          if (!this.key.equals(var2.key)) {
            return false;
          }
        } else if (var2.key != null) {
          return false;
        }
        if (this.value != null) {
          if (!this.value.equals(var2.value)) {
            return false;
          }
        } else if (var2.value != null) {
          return false;
        }
        return true;
      }
    }
  }
}
