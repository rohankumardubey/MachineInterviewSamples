package org.apache.practise.codeproblems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.practise.designproblems.BSTNode;
import org.apache.practise.designproblems.BinarySearchTree;

public class SecondMinimumInBinaryTree {
  private Queue<Integer> queue;
  public SecondMinimumInBinaryTree() {
    this.queue = new PriorityQueue<>(Collections.reverseOrder());
  }
  public void currentMinimunInBinaryTree(BSTNode bstNode) {
    if(bstNode==null) {
      return;
    }

    if(queue.size()>2) {
      queue.poll();
    }
    queue.add(bstNode.getData());
    currentMinimunInBinaryTree(bstNode.getLeft());
    currentMinimunInBinaryTree(bstNode.getRight());
  }

  int min1;
  long ans = Long.MAX_VALUE;

  public void dfs(BSTNode root) {
    if (root != null) {
      if (min1 < root.getData() && root.getData() < ans) {
        ans = root.getData();
      } else if (min1 == root.getData()) {
        dfs(root.getLeft());
        dfs(root.getRight());
      }
    }
  }
  public int findSecondMinimumValue(BSTNode root) {
    min1 = root.getData();
    dfs(root);
    return ans < Long.MAX_VALUE ? (int) ans : -1;
  }

  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.add();
    SecondMinimumInBinaryTree secondMinimumInBinaryTree = new SecondMinimumInBinaryTree();
    System.out.println(secondMinimumInBinaryTree.findSecondMinimumValue(binarySearchTree.getRoot()));
    System.out.println(secondMinimumInBinaryTree.findSecondMinimumValue(binarySearchTree.getRoot()));

  }
}
