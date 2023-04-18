package org.apache.practise.codeproblems;

import org.apache.practise.designproblems.BSTNode;

public class MaxDepthBinaryTree {
  public int maxDepth(BSTNode bstNode) {
    if(bstNode==null) {
      return 0;
    }
    int maxDepthLeft =  maxDepth(bstNode.getLeft());
    int maxDepthRight = maxDepth(bstNode.getRight());
    return Math.max(maxDepthLeft, maxDepthRight) + 1;
  }
}
