package org.apache.practise.codeproblems;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {

  public int evalRPN(String[] tokens) {
    LinkedList<Integer> stack = new LinkedList<>();
    for(String token: tokens) {
      char c = token.charAt(0);
      if(token.length()==1 && c<'0') {

      } else {
        stack.addLast(Integer.parseInt(token));
      }
    }
    return stack.removeLast();
  }

  private void evaluate(char c, LinkedList<Integer> stack) {
    final Integer second = stack.removeLast();
    final Integer first = stack.removeLast();
    switch (c) {
      case '+' :
        stack.addLast(first+second);
        break;
      case '-':
        stack.addLast(first-second);
        break;
      case '*':
        stack.addLast(first*second);
        break;
      case '/':
        stack.addLast(first/second);
    }
  }
}
