package org.uber.schedulerservice;

import java.util.Objects;
import java.util.Set;

public class TestGraph {
  private GridCell[][] grid;
  private Set<GridCell> visitedCells;

  public static void main(String[] args) {
  }

  private boolean isCaptured(int x, int y) {
    if (y > grid.length) {
      return false;
    }
    if (x > grid[0].length) {
      return false;
    }
    return visitedCells.isEmpty();
  }

  private void isCapturedInternal(int x, int y) {
    if(grid[x][y]==null) {
      return;
    }



  }

  private class GridCell {
    private char user;
    private int x;
    private int y;

    @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      GridCell gridCell = (GridCell) o;
      return user == gridCell.user && x == gridCell.x && y == gridCell.y;
    }

    @Override public int hashCode() {
      return Objects.hash(user, x, y);
    }
  }
}
