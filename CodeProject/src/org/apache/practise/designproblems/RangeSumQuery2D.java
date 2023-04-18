package org.apache.practise.designproblems;

public class RangeSumQuery2D {
  private int[][] data;
  public RangeSumQuery2D(int[][] data) {
    this.data = data;
  }

  public int sum(int rowId1, int colId1, int rowId2, int colId2) {
    int sum = 0;
    for (int i = rowId1; i <=rowId2 ; i++) {
      for (int j = colId1; j <=colId2 ; j++) {
        sum+=data[i][j];
      }
    }
    return sum;
  }

  public void update(int rowId, int colId, int number) {
    data[rowId][colId] = number;
  }

}
