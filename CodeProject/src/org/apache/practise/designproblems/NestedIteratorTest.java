package org.apache.practise.designproblems;

import java.util.ArrayList;
import java.util.List;

public class NestedIteratorTest {
  public static void main(String[] args) {
    List<NestedInteger> data = new ArrayList<>();
    NestedInteger nestedInteger = new NestedInteger();
    nestedInteger.setData(1);
    data.add(nestedInteger);

    List<NestedInteger> data1 = new ArrayList<>();
    NestedInteger nestedInteger1 = new NestedInteger();
    nestedInteger1.setData(2);
    data1.add(nestedInteger1);

    NestedInteger nestedInteger2 = new NestedInteger();
    List<NestedInteger> data3 = new ArrayList<>();
    NestedInteger nestedInteger3 = new NestedInteger();
    nestedInteger3.setData(6);
    data3.add(nestedInteger3);
    nestedInteger2.setDataList(data3);
    data1.add(nestedInteger2);
    data.addAll(data1);

    NestedIterator nestedIterator = new NestedIterator(data);
    while(nestedIterator.hasNext()) {
      System.out.println(nestedIterator.next());
    }

  }
}
