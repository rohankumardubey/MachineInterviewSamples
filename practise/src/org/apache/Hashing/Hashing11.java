package org.apache.Hashing;

import java.util.HashMap;
import java.util.Map;

//Check if two arrays are equal or not
public class Hashing11 {
  public static void main(String[] args) {
    int[] a = {4,4,4,4,0};
    int[] b = {4,4,4,4,0};
    Map<Integer,Integer> set = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      Integer integer = set.get(a[i]);
      if(null == integer) {
        set.put(a[i], 1);
      } else {
        set.put(a[i], ++integer);
      }
    }
    boolean isEqual = true;
    for (int i = 0; i < b.length; i++) {
      Integer integer = set.remove(b[i]);
      if(integer == null) {
        isEqual = false;
        break;
      } else if(integer>1){
        set.put(a[i], --integer);
      }
    }
    if(!isEqual || set.size()>0) {
      System.out.println("false");
    } else {
      System.out.println("true");
    }
  }

}
