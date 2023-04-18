package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
  public List<String> fullJustify(String[] words, int maxWidth) {
    String str = "";
    for (String word: words) {
      str += word + " ";
    }

    List<String> res = new ArrayList<>();
    int start = 0;
    while (start < str.length()) {
      int end = Math.min(start + maxWidth, str.length() - 1);
      while (end > start && str.charAt(end) != ' ') {
        end--;
      }
      String substring = str.substring(start, end);

      StringBuilder sb = new StringBuilder();
      int count = 0;
      int index = substring.indexOf(' ');
      while (index >= 0) {
        count++;
        index = substring.indexOf(' ', index + 1);
      }
      if (end == str.length() - 1 || count  == 0) {
        sb.append(substring);
        for (int i = 0; i < maxWidth - substring.length(); i++) {
          sb.append(' ');
        }
      } else {
        int spaces = maxWidth - (end - start - count);
        while (start < end) {
          char c = str.charAt(start);
          if (c != ' ') {
            sb.append(c);
          } else {
            int addSpace = spaces / count + (spaces % count == 0 ? 0 : 1);
            for (int i = 0; i < addSpace; i++) {
              sb.append(' ');
            }
            count--;
            spaces -= addSpace;
          }
          start++;
        }
      }
      res.add(sb.toString());
      start = end + 1;
    }
    return res;
  }
}
