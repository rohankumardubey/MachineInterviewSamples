package org.apache.practise.designproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
  public Map<Integer, Integer> map;
  public List<Integer> list;
  private int index = 0;
  private Random random;

  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
    this.random = new Random();
  }

  public boolean insert(int val) {
    if (!map.containsKey(val)) {
      list.add(val);
      map.put(val, list.size() - 1);
      return true;
    }
    return false;
  }

  public boolean remove(int val) {
    if (map.containsKey(val)) {
      Integer remove = map.remove(val);
      list.set(remove, list.get(list.size() - 1));
      list.remove(list.size() - 1);
      if (list.size() > 0) {
        map.put(list.get(remove), remove);
      }
      return true;
    }
    return false;
  }

  public int getRandomAllTime() {
    if (index >=list.size()) {
      index = 0;
    }
    final Integer integer = list.get(index);
    index++;
    return integer;
  }

  public int getRandom() {
    if(list.size() == 0)
      return -1;
    return list.get(random.nextInt(list.size()));
  }
}
