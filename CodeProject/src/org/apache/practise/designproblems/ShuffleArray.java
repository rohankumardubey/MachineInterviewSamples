package org.apache.practise.designproblems;

import java.util.Random;

public class ShuffleArray {
  private int[] original;
  private int[] shuffledArray;
  private Random random;

  public ShuffleArray(int[] data) {
    this.original = data;
    this.shuffledArray = data.clone();
    this.random = new Random();
  }

  public int[] reset() {
    return original;
  }

  public int[] shuffle() {
    for (int i = 0; i < shuffledArray.length; i++) {
      swap(i, getRandomIndex(i, shuffledArray.length));
    }
    return shuffledArray;
  }

  private int getRandomIndex(int min, int max) {
    return this.random.nextInt(max - min) + min;
  }

  private void swap(int firstIndex, int secondIndex) {
    int temp = shuffledArray[firstIndex];
    shuffledArray[firstIndex] = shuffledArray[secondIndex];
    shuffledArray[secondIndex] = temp;
  }
}
