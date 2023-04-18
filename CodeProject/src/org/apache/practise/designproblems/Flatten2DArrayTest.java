package org.apache.practise.designproblems;

public class Flatten2DArrayTest {
  public static void main(String[] args) {
    int[][] data = {{1,2,3},{4},{5,6,7,8,9},{0}};
    Flatten2DArray flatten2DArray = new Flatten2DArray(data);
    while(flatten2DArray.hasNext()) {
      System.out.println(flatten2DArray.next());
    }
  }
}
