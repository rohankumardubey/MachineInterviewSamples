package org.apache.String;

public class String2 {
  public static void main(String[] args) {
    String a = "vvikas";
    String b = "vvishal";
    byte[] c = new byte[26];
    for (int i = 0; i < a.length(); i++) {
      c[a.charAt(i) - 'a'] = 1;
    }
    for (int i = 0; i < b.length(); i++) {
      if (c[b.charAt(i) - 'a'] == 1 || c[b.charAt(i)-'a']==-1) {
        c[b.charAt(i) - 'a'] = -1;
      } else {
        c[b.charAt(i) - 'a'] = 2;
      }
    }

    for (int i = 0; i < c.length; i++) {
      if (c[i] == 1 || c[i]==2) {
        char d = (char) ('a' + i);
        System.out.println(d);
      }
    }
  }
}
