package org.apache.practise.codeproblems;

import org.apache.practise.designproblems.BSTNode;

public class BinaryTreeUpSideDown {
  private BSTNode newRoot;
  public BSTNode upsideDownBinaryTree(BSTNode root) {
    if(root == null) {
      return null;
    }
    turnLeft(root, null);
    return newRoot;
  }

  private void turnLeft(BSTNode root, BSTNode p) {
    if(root.getLeft()!=null) {
      turnLeft(root.getLeft(), root);
    } else {
      newRoot = root;
    }

    if(null!=p) {
      root.setLeft(p.getRight());
      root.setRight(p);
      p.setRight(null);
      p.setLeft(null);
    }
  }
}
