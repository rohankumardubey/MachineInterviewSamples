package org.apache.practise.designproblems;

import java.util.HashMap;
import java.util.Map;

public class WordDictionaryOne {
  private Dictionary dictionary;

  public WordDictionaryOne() {
    this.dictionary = new Dictionary();
  }

  private class Dictionary {
    private Map<Character, Dictionary> map;

    private Dictionary() {
      this.map = new HashMap<>();
    }

    private boolean isLeaf;
  }

  public void add(String word) {
    Dictionary current = dictionary;
    for (int i = 0; i < word.length(); i++) {
      if (null == current.map) {
        current.map = new HashMap<>();
      }
      Dictionary dictionary = current.map.get(word.charAt(i));
      if (null == dictionary) {
        dictionary = new Dictionary();
        current.map.put(word.charAt(i), dictionary);
      }
      current = dictionary;
    }
    current.isLeaf = true;
  }

  public boolean search(String word) {
    return searchWordInternal(word, 0, dictionary.map);
  }

  private boolean searchWordInternal(String word, int index, Map<Character, Dictionary> dict) {
    if (index == word.length()) {
      return dict.size() == 0;
    }
    char c = word.charAt(index);
    if (dict.containsKey(c)) {
      if (index == word.length() - 1 && dict.get(c).isLeaf) {
        return true;
      }
      return searchWordInternal(word, index + 1, dict.get(c).map);
    } else if (c == '.') {
      boolean result = false;
      for (Map.Entry<Character, Dictionary> d : dict.entrySet()) {
        if (index == word.length() - 1 && d.getValue().isLeaf) {
          return true;
        }
        if (searchWordInternal(word, index + 1, d.getValue().map)) {
          result = true;
        }
      }
      return result;
    } else {
      return false;
    }
  }
}
