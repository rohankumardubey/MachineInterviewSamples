package org.apache.practise.designproblems;

public class NumberOfIsland {
  private int[][] grid;

  public NumberOfIsland(int[][] grid) {
    this.grid = grid;
  }

  public int numberOfIsland() {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int numberOfIsand = 0;
    int numberOfRows = grid.length;
    int numberOfColumns = grid[0].length;
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumns; j++) {
        if (grid[i][j] == 1) {
          ++numberOfIsand;
          dfs(grid, i, j);
        }
      }
    }
    return numberOfIsand;
  }

  private void dfs(int[][] grid, int row, int column) {
    int numberOfRows = grid.length;
    int numberOfColumns = grid[0].length;
    if (row < 0 || column < 0 || row >= numberOfRows || column >= numberOfColumns
        || grid[row][column] == 0) {
      return;
    }

    grid[row][column] = 0;
    dfs(grid, row - 1, column);
    dfs(grid, row + 1, column);
    dfs(grid, row, column - 1);
    dfs(grid, row, column + 1);
  }
}
