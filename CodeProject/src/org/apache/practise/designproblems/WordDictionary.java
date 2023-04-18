package org.apache.practise.designproblems;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
  private Dictionary dictionary;

  private class Dictionary {
    private Map<Character, Dictionary> map;
    private Dictionary() {
      this.map = new HashMap<>();
    }
    private boolean isLeaf;
  }

  public WordDictionary() {
    this.dictionary = new Dictionary();
  }

  public void addWord(String data) {
    Dictionary t = dictionary;
    for (int i = 0; i < data.length(); i++) {
      if (t.map == null) {
        t.map = new HashMap<>();
      }
      Dictionary child = t.map.get(data.charAt(i));
      if (null == child) {
        child = new Dictionary();
        t.map.put(data.charAt(i), child);
      }
      t = child;
    }
    t.isLeaf = true;
  }

  public boolean searchWord(String regex) {
    return searchWord(regex, dictionary.map, 0);
  }

  private boolean searchWord(String word, Map<Character, Dictionary> dict, int start) {
    if (start == word.length()) {
      if (dict.size() == 0) {
        return true;
      } else {
        return false;
      }
    }
    char c = word.charAt(start);
    if (dict.containsKey(c)) {
      if (start == word.length() - 1 && dict.get(c).isLeaf) {
        return true;
      }
      return searchWord(word, dict.get(c).map, start + 1);
    } else if (c == '.') {
      boolean result = false;
      for (Map.Entry<Character, Dictionary> d : dict.entrySet()) {
        if (start == word.length() - 1 && d.getValue().isLeaf) {
          return true;
        }
        if (searchWord(word, d.getValue().map, start + 1)) {
          result = true;
        }
      }
      return result;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.searchWord(".ad"));
  }
}
