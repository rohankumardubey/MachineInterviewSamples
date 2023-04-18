package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.List;

public class FactorCombination {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> factors = getFactorList(n);
    helper(result, new ArrayList<Integer>(), n, 0, factors);
    return result;
  }

  public void helper(List<List<Integer>> result, List<Integer> item, int n, int start, List<Integer> factors){
    if (n <= 1) {
      if (n == 1 && item.size() > 1) {
        result.add(new ArrayList<Integer>(item));
      }
      return;
    }

    for (int i = start; i < factors.size(); i++) {
      if (n % factors.get(i) == 0) {
        item.add(factors.get(i));
        helper(result, item, n/factors.get(i), i, factors);
        item.remove(item.size() - 1);
      }
    }
  }
  private List<Integer> getFactorList(int n) {
    List<Integer> factors = new ArrayList<>();
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        factors.add(i);
      }
    }
    return factors;
  }
}
