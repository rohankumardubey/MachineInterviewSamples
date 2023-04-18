package org.apache.practise.designproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomSetDuplicate {
  private Map<Integer, Set<Integer>> map;
  private List<Integer> dataList;
  private int index;
  private Random random;
  public RandomSetDuplicate() {
    this.map = new HashMap<>();
    this.dataList = new ArrayList<>();
  }

  public boolean add(int data) {
    boolean isPresent = map.containsKey(data);
    dataList.add(data);
    final Set<Integer> indexSet = map.getOrDefault(data, new HashSet<>());
    indexSet.add(dataList.size() - 1);
    map.put(data, indexSet);
    return !isPresent;
  }

  public boolean remove(int data) {
    final Set<Integer> integers = map.get(data);
    if (null != integers) {
      final Integer next = integers.iterator().next();
      integers.remove(next);
      if (integers.size() == 0) {
        map.remove(data);
      }
      int currentSize = dataList.size() - 1;
      final Integer lastIndexElement = dataList.get(currentSize);
      dataList.set(next, lastIndexElement);
      dataList.remove(currentSize);
      if (dataList.size() > 0) {
        final Set<Integer> integers1 = map.get(lastIndexElement);
        if (integers1.size() > 0) {
          integers1.remove(currentSize);
          integers1.add(next);
        }

      } else {
        map.clear();
      }
      return true;
    }
    return false;
  }

  public int getRandomAllTime() {
    if (index >= dataList.size()) {
      index = -1;
    }
    final Integer integer = dataList.get(index);
    index++;
    return integer;
  }

  public int getRandom() {
    if(dataList.size()==0) {
      return -1;
    }
    return dataList.get(random.nextInt(dataList.size()));
  }

}
