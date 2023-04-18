package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
  public MergeIntervals(int[] data) {
    List<Interval> intervalList = new ArrayList<>();
    for (int i = 0; i < data.length; i++) {
      Interval interval = new Interval();
      interval.start = data[0];
      interval.end = data[1];
      intervalList.add(interval);
    }
    Collections.sort(intervalList, new IntervalComparator());
    LinkedList<Interval> merged = new LinkedList<>();
    for (Interval interval : intervalList) {
      if (merged.isEmpty() || merged.getLast().end < interval.start) {
        merged.add(interval);
      } else {
        merged.getLast().end = Math.max(merged.getLast().end, interval.end);
      }
    }
  }

  private class IntervalComparator implements Comparator<Interval> {
    @Override public int compare(Interval o1, Interval o2) {
      return o1.start - o2.start;
    }
  }

  private class Interval {
    private int start;
    private int end;
  }
}
