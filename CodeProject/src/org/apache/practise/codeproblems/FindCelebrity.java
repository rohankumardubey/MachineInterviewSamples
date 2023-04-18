package org.apache.practise.codeproblems;

public class FindCelebrity {

  public int findCelebrity(int n) {
    if (n < 0) return -1;
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      if (knows(candidate, i)) candidate = i;
    }
    for (int i = 0; i < n; i++) {
      if (i < candidate) {
        if (knows(candidate, i)) return -1;
        if (!knows(i, candidate)) return -1;
      } else if (i > candidate) {
        if (!knows(i, candidate)) return -1;
      } else {
        // i == candidate
        continue;
      }
    }
    return candidate;
  }
}
