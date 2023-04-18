package org.apache.practise.codeproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    Map<Character, Character> mappings = new HashMap<>();
    mappings.put(')', '(');
    mappings.put('}', '{');
    mappings.put(']', '[');
    String s = ")([]{}";
    isValid(s, mappings);

  }

  public static boolean isValid(String s, Map<Character, Character> mappings ) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (mappings.containsKey(c)) {
        char topElement = stack.empty() ? '#' : stack.pop();
        if (topElement != mappings.get(c)) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
