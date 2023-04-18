package org.apache.Hashing;

import java.util.HashMap;
import java.util.Map;

//First element to occur k times
public class Hashing14 {
  public static void main(String[] args) {
    int a[] = {1,7, 4, 3, 4, 8, 7};
    int k = 2;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      Integer integer = map.get(a[i]);
      if(integer==null) {
        map.put(a[i], 1);
      } else {
        integer+=1;
        map.put(a[i], integer);
        }
      }
    for (int i = 0; i < a.length; i++) {
      Integer integer = map.get(a[i]);
      if(integer == k) {
        System.out.println(a[i]);
        break;
    }
    }
  }
}
