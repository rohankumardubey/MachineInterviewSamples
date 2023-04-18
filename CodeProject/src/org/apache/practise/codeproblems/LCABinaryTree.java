package org.apache.practise.codeproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.practise.designproblems.BSTNode;

public class LCABinaryTree {

  public BSTNode lca(BSTNode root, BSTNode p, BSTNode q) {
    Stack<BSTNode> stack = new Stack<>();
    Map<BSTNode, BSTNode> parent = new HashMap<>();
    stack.push(root);
    parent.put(root, null);
    while (!parent.containsKey(p) || !parent.containsKey(q)) {
      final BSTNode pop = stack.pop();
      if (pop.getLeft() != null) {
        parent.put(pop.getLeft(), pop);
        stack.push(pop.getLeft());
      }
      if (pop.getRight() != null) {
        parent.put(pop.getRight(), pop);
        stack.push(pop.getRight());
      }
    }
    Set<BSTNode> ancestors = new HashSet<>();
    while(p!=null) {
      ancestors.add(p);
      p = parent.get(p);
    }
    while(ancestors.contains(q)) {
       q = parent.get(q);
    }
    return q;
  }
}
