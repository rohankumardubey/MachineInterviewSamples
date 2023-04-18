package org.apache.practise.designproblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeBinaryTree {

  public String serializeBinaryTree(BSTNode bstNode) {
    StringBuilder stringBuilder = new StringBuilder();
    serializeInternal(bstNode, stringBuilder);
    return stringBuilder.toString();
  }

  private void serializeInternal(BSTNode bstNode, StringBuilder stringBuilder) {
    if (null == bstNode) {
      stringBuilder.append("null,");
      return;
    }
    stringBuilder.append(bstNode.getData()+",");
    serializeInternal(bstNode.getLeft(), stringBuilder);
    serializeInternal(bstNode.getRight(), stringBuilder);
  }

  public BSTNode rdeserialize(List<String> l) {
    if (l.get(0).equals("null")) {
      l.remove(0);
      return null;
    }
    BSTNode root = new BSTNode(Integer.valueOf(l.get(0)));
    l.remove(0);
    root.setLeft(rdeserialize(l));
    root.setRight(rdeserialize(l));
    return root;
  }
  // Decodes your encoded data to tree.
  public BSTNode deserialize(String data) {
    String[] data_array = data.split(",");
    List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
    return rdeserialize(data_list);
  }
}
