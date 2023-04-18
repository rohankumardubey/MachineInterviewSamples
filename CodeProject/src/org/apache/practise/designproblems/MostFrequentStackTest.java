package org.apache.practise.designproblems;

public class MostFrequentStackTest {
  public static void main(String[] args) {
    MostFrequentStack mostFrequentStack = new MostFrequentStack();
    String s  = "5,5,7,4,5";
    final String[] split = s.split(",");
    for (int i = 0; i <split.length ; i++) {
      mostFrequentStack.push(Integer.parseInt(split[i]));
    }
    System.out.println(mostFrequentStack.pop());
    System.out.println(mostFrequentStack.pop());
    System.out.println(mostFrequentStack.pop());
    System.out.println(mostFrequentStack.pop());
  }
}
