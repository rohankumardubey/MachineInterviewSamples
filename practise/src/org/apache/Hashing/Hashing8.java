package org.apache.Hashing;

import java.util.HashSet;
import java.util.Set;

// Find first repeated character
public class Hashing8 {
  public static void main(String[] args) {
    String a = "hellogeeks";
    final char[] chars = a.toCharArray();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i <chars.length ; i++) {
      if(set.contains(chars[i])) {
        System.out.println(chars[i]);
        break;
      } else{
        set.add(chars[i]);
      }
    }
  }
}
