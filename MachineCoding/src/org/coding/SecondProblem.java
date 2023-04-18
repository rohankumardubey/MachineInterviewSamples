package org.coding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SecondProblem {
  public static void main(String[] args) {
    String[][] data =
        { { "c1", "c2" }, { "c8", "c9" }, { "c1", "c3" }, { "c2", "C4" }, { "c10", "c11" },
            { "c5", "c8" }, { "c14", "c13" }, { "c13", "c12" }, { "c12", "c11" } };
    printNodeToLabel(data);
  }

  public static void printNodeToLabel(String[][] data) {
    Map<String, Set<String>> parentToChildMap = new LinkedHashMap<>();
    Map<String, String> childToParentMap = new HashMap<>();
    for (int i = 0; i < data.length; i++) {
      String firstParent = childToParentMap.get(data[i][0]);
      String secondParent = childToParentMap.get(data[i][1]);
      if (null != firstParent && null != secondParent && !firstParent.equals(secondParent)) {
        if (parentToChildMap.get(firstParent).size() > parentToChildMap.get(secondParent).size()) {
          mergeMultiParent(firstParent, secondParent, data[i][1], parentToChildMap,
              childToParentMap);

        } else {
          mergeMultiParent(secondParent, firstParent, data[i][0], parentToChildMap,
              childToParentMap);
        }
        firstParent = childToParentMap.get(data[i][0]);
        secondParent = childToParentMap.get(data[i][1]);
      }
      String parent;
      boolean isNewNode = true;
      boolean isFirstAsParent = true;
      if (null == firstParent && secondParent == null) {
        parent = data[i][0];
      } else {
        isNewNode = false;
        parent = firstParent;
        if (null != secondParent) {
          parent = secondParent;
          isFirstAsParent = false;
        }
      }
      final Set<String> orDefault = parentToChildMap.getOrDefault(parent, new LinkedHashSet<>());
      orDefault.add(data[i][0]);
      orDefault.add(data[i][1]);
      parentToChildMap.put(parent, orDefault);
      if (isNewNode) {
        childToParentMap.put(data[i][1], parent);
        childToParentMap.put(data[i][0], parent);
      } else {
        if (isFirstAsParent) {
          childToParentMap.put(data[i][1], parent);
        } else {
          childToParentMap.put(data[i][0], parent);
        }
      }
    }
    printNodeToLabel(parentToChildMap);
  }

  private static void printNodeToLabel(Map<String, Set<String>> parentToChildMap) {
    final Iterator<Map.Entry<String, Set<String>>> iterator =
        parentToChildMap.entrySet().iterator();
    System.out.println("Node->Label");
    while (iterator.hasNext()) {
      final Map.Entry<String, Set<String>> next = iterator.next();
      final String key = next.getKey();
      final Iterator<String> iterator1 = next.getValue().iterator();
      while (iterator1.hasNext()) {
        System.out.println(iterator1.next() + "->" + key);
      }
    }
  }

  private static void mergeMultiParent(String newParent, String oldParent, String childName,
      Map<String, Set<String>> parentToChildMap, Map<String, String> childToParentMap) {
    final Set<String> remove = parentToChildMap.remove(oldParent);
    parentToChildMap.get(newParent).addAll(remove);
    childToParentMap.put(childName, newParent);
    final Iterator<String> iterator = remove.iterator();
    while (iterator.hasNext()) {
      childToParentMap.put(iterator.next(), newParent);
    }
  }
}
