package org.apache.practise.designproblems;

public class RandomSetDuplicateTest {
  public static void main(String[] args) {
    RandomSetDuplicate randomSetDuplicate = new RandomSetDuplicate();
    randomSetDuplicate.add(1);
    randomSetDuplicate.add(2);
    randomSetDuplicate.add(1);
    randomSetDuplicate.remove(1);
    randomSetDuplicate.remove(1);
//    randomSetDuplicate.add(3);
  }
}
