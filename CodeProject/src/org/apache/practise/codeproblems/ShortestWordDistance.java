package org.apache.practise.codeproblems;

public class ShortestWordDistance {
  public static void main(String[] args) {
    String [] s = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "coding";
    String word2 = "practice";
    int minDistance = s.length;
    int first = -1;
    int second = -1;
    for (int i = 0; i < s.length; i++) {
      if(word1.equalsIgnoreCase(s[i])) {
        first = i;
      } else if(word2.equalsIgnoreCase(s[i])) {
        second = i;
      }
      if(first!=-1 && second!=-1) {
        minDistance = Math.min(minDistance, Math.abs(first-second));
      }
    }
    System.out.println(minDistance);
  }
}
