package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

  public static void main(String[] args) {
    int n = 2;
    List<String> list = new ArrayList<>();
    list.add("0:start:0");
    list.add("1:start:2");
    list.add("1:end:5");
    list.add("0:end:6");
    System.out.println(Arrays.toString(exclusiveTime(n, list)));
  }

  public static int[] exclusiveTime(int n, List<String> logs) {
    Stack<Integer> stack = new Stack<>();
    int res[] = new int[n];
    String[] split = logs.get(0).split(":");
    stack.push(Integer.parseInt(split[0]));
    int counter = 1;
    int prv = Integer.parseInt(split[2]);
    while (counter < logs.size()) {
      split = logs.get(counter).split(":");
      if (split[1].equals("start")) {
        if (!stack.isEmpty()) {
          res[stack.peek()] += Integer.parseInt(split[2]) - prv;
        }
        stack.push(Integer.parseInt(split[0]));
        prv = Integer.parseInt(split[2]);
      } else {
        res[stack.peek()] += Integer.parseInt(split[2]) - prv + 1;
        stack.pop();
        prv = Integer.parseInt(split[2]) + 1;
      }

    }
    return res;
  }
}
