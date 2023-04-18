package org.apache.Hashing;

import java.util.HashMap;
import java.util.Map;
//Minimum indexed character
public class Hashing10 {
  public static void main(String[] args) {
    String a ="geeksforgeeks";
    String b = "set";
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < a.length(); i++) {
      map.putIfAbsent((int) a.charAt(i), i);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < b.length(); i++) {
      final Integer integer = map.get((int)b.charAt(i));
      if(null!=integer && min>integer) {
        min = integer;
      }
    }
    if(min!=Integer.MAX_VALUE) {
      System.out.println("char found at: " + (b.charAt(min)));
      System.out.println(min);
    } else {
      System.out.println("no char found");
    }
  }

}
