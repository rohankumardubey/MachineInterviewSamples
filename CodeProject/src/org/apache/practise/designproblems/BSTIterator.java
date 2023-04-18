package org.apache.practise.designproblems;

import java.util.Iterator;
import java.util.Stack;

public class BSTIterator implements Iterator<Integer> {
  private BSTNode bstNode;
  private Stack<BSTNode> bstNodes;

  public BSTIterator(BSTNode bstNode) {
    this.bstNode = bstNode;
    this.bstNodes = new Stack<>();
    leftMostTraverse(bstNode);
  }

  private void leftMostTraverse(BSTNode bstNode) {
    while (bstNode != null) {
      bstNodes.add(bstNode);
      bstNode = bstNode.getLeft();
    }
  }

  @Override public boolean hasNext() {
    return bstNodes.size() > 0;
  }

  @Override public Integer next() {
    final BSTNode pop = bstNodes.pop();
    if (pop.getRight() != null) {
      leftMostTraverse(bstNode.getRight());
    }
    return pop.getData();
  }
}
