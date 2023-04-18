package org.apache.practise.designproblems;

public class HitCountTest {
  public static void main(String[] args) {
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(1);
    hitCounter.hit(2);
    hitCounter.hit(10);
    System.out.println(hitCounter.getHits(600));
  }
}
