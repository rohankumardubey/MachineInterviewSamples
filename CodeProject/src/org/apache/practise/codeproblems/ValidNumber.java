package org.apache.practise.codeproblems;

public class ValidNumber {
  private static final java.util.regex.Pattern base = java.util.regex.Pattern.compile("^[-+]?(\\d)+[.]?(\\d)*$");
  private static final java.util.regex.Pattern base1 = java.util.regex.Pattern.compile("^[-+]?[.]?(\\d)+$");
  private static final java.util.regex.Pattern exp = java.util.regex.Pattern.compile("^[-+]?(\\d)+$");

  public boolean isNumber(String s) {
    String p = s.trim();
    int e = p.indexOf('e');

    if (e == -1) {
      return isValidBase(p);
    } else {
      return isValidBase(p.substring(0, e)) &&
          exp.matcher(p.substring(e + 1)).matches();
    }
  }

  private boolean isValidBase(String b) {
    return base.matcher(b).matches() || base1.matcher(b).matches();
  }
}
