package org.apache.practise.designproblems;

public class ShortestWordDistanceTest {
  public static void main(String[] args) {
    String[] data = {"practice", "makes", "perfect", "coding", "makes", "practice"};
    String word1 = "coding";
    String word2 = "practice";
    ShortestWordDistance shortestWordDistance = new ShortestWordDistance(data);
    System.out.println(shortestWordDistance.shortestDistance(word1, word2));
  }
}
