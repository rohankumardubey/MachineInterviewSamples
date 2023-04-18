package org.apache.practise.designproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {

  private Map<String, List<Integer>> wordToLocationsMap;

  public ShortestWordDistance(String[] words) {
    this.wordToLocationsMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      final List<Integer> orDefault =
          this.wordToLocationsMap.getOrDefault(words[i], new ArrayList<>());
      orDefault.add(i);
      this.wordToLocationsMap.put(words[i], orDefault);
    }
  }

  public int shortestDistance(String word1, String word2) {
    List<Integer> firstWordLocations = wordToLocationsMap.get(word1);
    List<Integer> secondWordLocations = wordToLocationsMap.get(word2);
    if (null == firstWordLocations || null == secondWordLocations) {
      return Integer.MAX_VALUE;
    }

    int index = 0;
    int index1 = 0;
    int minDiff = Integer.MAX_VALUE;
    while(index<firstWordLocations.size() && index1<secondWordLocations.size()) {
      minDiff = Math.min(minDiff, Math.abs(firstWordLocations.get(index) - secondWordLocations.get(index1)));
      if(firstWordLocations.get(index) < secondWordLocations.get(index1)) {
        index++;
      } else {
        index1++;
      }
    }
    return minDiff;
  }
}
