package org.apache.practise.designproblems;

import java.util.Arrays;

public class ShuffleArrayTest {
  public static void main(String[] args) {
    int[] data = {1,2,3,4,5};
    ShuffleArray shuffleArray = new ShuffleArray(data);
    System.out.println(Arrays.toString(shuffleArray.shuffle()));
    System.out.println(Arrays.toString(shuffleArray.shuffle()));
    System.out.println(Arrays.toString(shuffleArray.shuffle()));
    System.out.println(Arrays.toString(shuffleArray.reset()));
    System.out.println(Arrays.toString(shuffleArray.shuffle()));
  }
}
