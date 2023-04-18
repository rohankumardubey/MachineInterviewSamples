package org.apache.practise.codeproblems;

public class IsomorphicStrings {
  private static final int ASCII_LENGTH = 128;

  public boolean isIsomorphic(String s, String t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }
    Integer[] sToT = new Integer[ASCII_LENGTH];
    Integer[] tToS = new Integer[ASCII_LENGTH];
    for (int i = 0; i < s.length(); i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      if (!isEmptyOrEqual(sToT, sc, tc) || !isEmptyOrEqual(tToS, tc, sc)) {
        return false;
      }
      sToT[sc] = Integer.valueOf(tc);
      tToS[tc] = Integer.valueOf(sc);
    }
    return true;
  }

  private boolean isEmptyOrEqual(Integer[] arr, char key, char value) {
    if (arr[key] == null) return true;
    return arr[key] == value;
  }
}
