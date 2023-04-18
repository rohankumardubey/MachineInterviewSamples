package org.apache.practise.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Test {
  public static void main(String[] args) throws UnsupportedEncodingException {
    String base64encodedString = Base64.getEncoder().encodeToString(
        "1".getBytes("utf-8"));

    System.out.println(base64encodedString.length());
  }
}
