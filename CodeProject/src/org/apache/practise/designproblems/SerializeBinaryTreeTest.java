package org.apache.practise.designproblems;

public class SerializeBinaryTreeTest {
  public static void main(String[] args) {
    SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(5);
    binarySearchTree.insert(4);
    binarySearchTree.insert(6);
    binarySearchTree.insert(3);
    binarySearchTree.insert(8);
    binarySearchTree.insert(10);
    final String s = serializeBinaryTree.serializeBinaryTree(binarySearchTree.getRoot());
    System.out.println(s);
    final BSTNode deserialize = serializeBinaryTree.deserialize(s);
    System.out.println();
  }
}
