package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWeight {
  private List<Integer> integerList;
  private int total;
  private Random random;
  public RandomPickWeight(int[] w) {
    integerList = new ArrayList<>();
    for (int i = 0; i <w.length ; i++) {
      this.total+=w[i];
      integerList.add(this.total);
    }
    random = new Random();
  }

  public int pickIndex() {
    int tar = random.nextInt(total);
    int low = 0;
    int high = integerList.size()-1;

    while(low!=high) {
      int mid = (low+high)/2;
      if(tar>=integerList.get(mid)) {
        low=mid+1;
      } else {
        high = mid-1;
      }
    }
    return low;
  }

}
