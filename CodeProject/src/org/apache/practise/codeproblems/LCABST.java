package org.apache.practise.codeproblems;

import org.apache.practise.designproblems.BSTNode;

public class LCABST {

  public BSTNode lca(BSTNode bstNode, BSTNode p, BSTNode q) {
    int parentVal = bstNode.getData();
    int pVal = p.getData();
    int qVal = q.getData();
    if(pVal> parentVal && qVal > parentVal) {
      return lca(bstNode.getRight(), p, q);
    } else if(pVal<parentVal && qVal<parentVal) {
      return lca(bstNode.getLeft(), p, q);
    } else {
      return bstNode;
    }
  }
}
