package org.apache.practise.programs;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
  public static void main(String[] args) {
    String str = "abc";
    int index = -1;
    String curr = "";
    powerSet(str.toCharArray(), index, curr);
  }

  private static void powerSet(String s, int index, String currentString) {
    int n = s.length();
    if (index == n) {
      return;
    }
    System.out.println(currentString);
    for (int i = index + 1; i < n; i++) {
      currentString += s.charAt(i);
      powerSet(s, i, currentString);
      currentString = currentString.substring(0, currentString.length() - 1);
    }
  }

  private static void powerSet(char[] data, int index, String s) {
    int n = data.length;
    if (index == n) {
      return;
    }
    System.out.println(s);
    for (int i = index + 1; i < n; i++) {
      s+=data[i];
      powerSet(data, i, s);
      s = s.substring(0, s.length() - 1);
    }
  }
}
