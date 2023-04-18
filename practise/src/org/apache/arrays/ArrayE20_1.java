package org.apache.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Given two arrays A1[] and A2[] of size N and M respectively.
// The task is to sort A1 in such a way that the relative order among the elements
// will be same as those in A2. For the elements not present in A2,
// append them at last in sorted order. It is also given that the number of
// elements in A2[] are smaller than or equal to number of elements in A1[] and A2[]
// has all distinct elements
public class ArrayE20_1 {
  public static void main(String[] args) {
    int a[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    int b[] = {2, 1, 10, 3};
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      Integer integer = map.get(a[i]);
      if(integer ==  null) {
        map.put(a[i], 1);
      } else {
        map.put(a[i], ++integer);
      }
    }
    int counter=0;
    for (int i = 0; i <b.length ; i++) {
      final Integer integer = map.remove(b[i]);
      if(integer!=null) {
        for (int j = 0; j < integer; j++) {
          a[counter++] = b[i];
        }
      }
    }
    final Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
    List<Integer> list = new ArrayList<>();
    final Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
    while(iterator.hasNext()) {
      final Map.Entry<Integer, Integer> next = iterator.next();
      final Integer value = next.getValue();
      final Integer key = next.getKey();
      for (int i = 0; i < value; i++) {
        list.add(key);
      }
    }
    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      a[counter++] = list.get(i);
    }
    System.out.println(Arrays.toString(a));
  }
}
