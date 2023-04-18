package org.apache.practise.designproblems;

public class BinarySearchTree {
  private BSTNode root;

  public BSTNode getRoot() {
    return root;
  }
  public void insert(int data) {
    root = insert(root, data);
  }
  private BSTNode insert(BSTNode root, int data) {
    if(root==null) {
      return new BSTNode(data);
    }
    if(data<root.getData()) {
      root.setLeft(insert(root.getLeft(), data));
    } else {
      root.setRight(insert(root.getRight(), data));
    }
    return root;
  }

  public void add() {
    root = new BSTNode(2);
    root.setLeft(new BSTNode(2));
    root.setRight(new BSTNode(5));
    root.getRight().setLeft(new BSTNode(5));
    root.getRight().setRight(new BSTNode(7));
  }
  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(5);
    binarySearchTree.insert(4);
    binarySearchTree.insert(6);
    binarySearchTree.insert(3);
    binarySearchTree.insert(8);
    binarySearchTree.insert(10);
  }
}
