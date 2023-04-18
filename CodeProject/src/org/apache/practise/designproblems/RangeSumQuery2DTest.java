package org.apache.practise.designproblems;

public class RangeSumQuery2DTest {
  public static void main(String[] args) {
    int[][] data = {{3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}};
    RangeSumQuery2D rangeSumQuery2D= new RangeSumQuery2D(data);
    System.out.println(rangeSumQuery2D.sum(2,1,4,3));
    rangeSumQuery2D.update(3, 2, 2);
    System.out.println(rangeSumQuery2D.sum(2,1,4,3));
  }
}
