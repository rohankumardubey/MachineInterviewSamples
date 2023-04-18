package org.apache.practise.designproblems;

public class TrieTest {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.addWord("vishal");
    trie.addWord("vish");
    trie.addWord("vishalv");
//    System.out.println(trie.search("vish"));
//    System.out.println(trie.search("visha"));
//    System.out.println(trie.search("vishal"));
//    System.out.println(trie.search("vishalv"));
//    System.out.println(trie.search("vikas"));
    trie.addWord("vikas");
//    System.out.println(trie.search("vikas"));
//    System.out.println(trie.startsWith("shi"));
//    System.out.println(trie.startsWith("visha"));
//    System.out.println(trie.startsWith("vik"));

    System.out.println(trie.getAllKey());
  }
}
