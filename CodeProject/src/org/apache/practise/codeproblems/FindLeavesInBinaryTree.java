package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.List;

import org.apache.practise.designproblems.BSTNode;

public class FindLeavesInBinaryTree {

  public List<List<Integer>> findLeaves(BSTNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    boolean stop = false;
    while (!stop) {
      List<Integer> list = new ArrayList<>();
      stop = removeAllLeaves(root, list);
      lists.add(list);
    }
    return lists;
  }

  private boolean removeAllLeaves(BSTNode bstNode, List<Integer> list) {
    if (bstNode != null) {
      if (bstNode.getLeft() == null && bstNode.getRight() == null) {
        list.add(bstNode.getData());
        return true;
      }
      if (removeAllLeaves(bstNode.getLeft(), list)) {
        bstNode.setLeft(null);
      }
      if (removeAllLeaves(bstNode.getRight(), list)) {
        bstNode.setRight(null);
      }
    }
    return false;
  }
}
