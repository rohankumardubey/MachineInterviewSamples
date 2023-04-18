package org.apache.practise.machinecoding.autocompletesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AutoCompleteSystem {
  private TrieNode trieNode;
  private String s = "";

  public AutoCompleteSystem(String[] sentences, int[] numberOfTimes) {
    this.trieNode = new TrieNode();
    int counter = 0;
    for (String sentence : sentences) {
      this.trieNode.insert(sentence, numberOfTimes[counter++]);
    }
  }

  public List<String> input(char c) {
    List<String> data = new ArrayList<>();
    if (c == '#') {
      this.trieNode.insert(s, 1);
      s = "";
      return data;
    }
    s += c;
    final Queue<Node> queue = trieNode.searchTop(s);
    int counter = 0;
    while (!queue.isEmpty() && counter < 3) {
      data.add(queue.poll().getData());
      counter++;
    }
    return data;
  }
}
