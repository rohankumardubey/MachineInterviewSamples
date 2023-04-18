package org.apache.practise.designproblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeBinaryTreeOne {

  public String serializeBinaryTree(BSTNode bstNode) {
    StringBuilder builder = new StringBuilder();
    serializeBinaryTreeInternal(bstNode, builder);
    return builder.toString();
  }

  private void serializeBinaryTreeInternal(BSTNode bstNode, StringBuilder stringBuilder) {
    if (bstNode == null) {
      stringBuilder.append("null,");
      return;
    }
    stringBuilder.append(bstNode.getData() + ",");
    serializeBinaryTreeInternal(bstNode.getLeft(), stringBuilder);
    serializeBinaryTreeInternal(bstNode.getRight(), stringBuilder);
  }

  public BSTNode deserializeBST(String str) {
    final String[] split = str.split(",");
    List<String> list = new LinkedList<>(Arrays.asList(split));
    return deserializeBSTInternal(list);
  }

  private BSTNode deserializeBSTInternal(List<String> stringList) {
    if(stringList.get(0).equals("null")) {
      stringList.remove(0);
    }

    BSTNode bstNode = new BSTNode(Integer.valueOf(stringList.get(0)));
    stringList.remove(0);
    bstNode.setLeft(deserializeBSTInternal(stringList));
    bstNode.setRight(deserializeBSTInternal(stringList));
    return bstNode;
  }
}
