package org.apache.Hashing;

//Smallest window in a string containing all the characters of another string
public class Hashing13 {
  public static void main(String[] args) {
    String a = "timetopractice";
    String b = "toc";
    byte[] data = new byte[256];
    for (int i = 0; i < b.length(); i++) {
      data[b.charAt(i)-'a'] =1;
    }
    for (int i = 0; i < a.length(); i++) {

    }
  }
}
