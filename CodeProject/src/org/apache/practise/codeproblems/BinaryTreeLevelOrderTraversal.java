package org.apache.practise.codeproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.practise.designproblems.BSTNode;
import org.apache.practise.designproblems.BinarySearchTree;

public class BinaryTreeLevelOrderTraversal {

  public static List<List<Integer>> levelOrder(BSTNode bstNode) {
    List<List<Integer>> list = new ArrayList<>();
    if (null == bstNode) {
      return list;
    }
    Queue<BSTNode> queue = new LinkedList<>();
    queue.add(bstNode);
    int level = 0;
    while (!queue.isEmpty()) {
      list.add(new ArrayList<>());
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        final BSTNode poll = queue.poll();
        list.get(level).add(poll.getData());
        if (poll.getLeft() != null) {
          queue.add(poll.getLeft());
        }
        if (poll.getRight() != null) {
          queue.add(poll.getRight());
        }
      }
      level++;
    }
    return list;
  }

  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(5);
    binarySearchTree.insert(4);
    binarySearchTree.insert(6);
    binarySearchTree.insert(3);
    binarySearchTree.insert(8);
    binarySearchTree.insert(10);
    System.out.println(levelOrder(binarySearchTree.getRoot()));
  }
}
