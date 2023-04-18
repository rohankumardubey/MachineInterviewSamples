package org.apache.String;
// first repeated character
public class String1 {
  public static void main(String[] args) {
    String a = "hellogeeks";
    byte[] ascii = new byte[128];
    final char[] chars = a.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      ascii[chars[i]]++;
      if(ascii[chars[i]] > 1) {
        System.out.println(chars[i]);
        break;
      }
    }
  }
}
