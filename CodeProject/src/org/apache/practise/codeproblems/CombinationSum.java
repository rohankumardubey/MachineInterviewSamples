package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<Integer> list = new ArrayList<>();
    Arrays.sort(candidates);
    combinationSum(candidates, target, list);
    return res;
  }

  private void combinationSum(int[] candidates, int target, List<Integer> list) {
    if (target == 0) {
      res.add(new ArrayList<>(list));
    } else if (target > 0) {
      for (int candidate : candidates) {
        if (candidate > target) {
          break;
        }
        if (list.size() > 0 && candidate < list.get(list.size() - 1)) {
          continue;
        }
        list.add(candidate);
        combinationSum(candidates, target - candidate, list);
        list.remove(Integer.valueOf(candidate));
      }
    }
  }
}
