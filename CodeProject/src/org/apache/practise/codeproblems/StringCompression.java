package org.apache.practise.codeproblems;

public class StringCompression {
  public static void main(String[] args) {
    String s = "vvishaaal";
    int counter;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      counter = 1;
      while (i + 1 < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
        counter++;
        i++;
      }
      stringBuilder.append(s.charAt(i));
      if (counter > 1) {
        stringBuilder.append(counter);
      }
    }
    System.out.println(stringBuilder.toString());
  }
}
