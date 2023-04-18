package org.apache.practise.patternmatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
  public static void main(String[] args) {
    final Pattern compile = Pattern.compile("[a-d1-7]");
    final Matcher a = compile.matcher("d1");
    System.out.println(a.find());
  }
}
