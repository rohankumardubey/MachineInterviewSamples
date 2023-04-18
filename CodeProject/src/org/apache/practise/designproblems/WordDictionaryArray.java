package org.apache.practise.designproblems;

public class WordDictionaryArray {
  private class Dictionary {
    private Dictionary[] dict;
    private boolean isLeaf;
  }

  private Dictionary dictionary;

  public WordDictionaryArray() {
    this.dictionary = new Dictionary();
  }

  public void addWord(String word) {
    Dictionary current = this.dictionary;
    for (int i = 0; i < word.length(); i++) {
      if (current.dict == null) {
        current.dict = new Dictionary[26];
      }
      int index = charToInt(word.charAt(i));
      if (current.dict[index] == null) {
        current.dict[index] = new Dictionary();
      }
      current = current.dict[index];
    }
    current.isLeaf = true;
  }

  public boolean serachWord(String word) {
    return searchInternal(word, 0, dictionary);
  }

  private boolean searchInternal(String word, int index, Dictionary dictionary) {
    if (dictionary.isLeaf && index == word.length()) {
      return true;
    }
    if (index >= word.length()) {
      return false;
    }
    char c = word.charAt(index);
    if (c == '.') {
      boolean result = false;
      for (int i = 0; i < 26; i++) {
        if (dictionary.dict[i] != null) {
          if (searchInternal(word, index + 1, dictionary.dict[i])) {
            result = true;
            break;
          }
        }
      }
      if (result) {
        return true;
      }
    } else {
      int arrayIndex = charToInt(c);
      if (dictionary.dict[arrayIndex] != null) {
        return searchInternal(word, index + 1, dictionary.dict[arrayIndex]);
      } else {
        return false;
      }
    }
    return false;
  }

  private int charToInt(char c) {
    return c - 'a';
  }

  public static void main(String[] args) {
    WordDictionaryArray wordDictionary = new WordDictionaryArray();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.addWord("mun");
    System.out.println(wordDictionary.serachWord("..n"));
  }
}
