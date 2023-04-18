package org.uber.schedulerservice;

import java.util.Set;
import java.util.TreeSet;

public class Test {
  private static int[][] board;
  private static Set<Integer> map = new TreeSet<>();

  public static void main(String[] args) {

    board = new int[5][6];
    int[] a = new int[5];
    a[0] = 0;
    a[1] = 10;
    a[2] = 20;
    a[3] = 30;
    a[4] = 40;
    for (int i = 0; i < board.length; i++) {
      int x = a[i];
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = x + j;
      }
    }
    visitAll(board, 2, 3);
    System.out.println(board);
    System.out.println(map);
  }

  private static void visitAll(int[][] board, int x, int y) {
    if (x < 0 || x >= 5 || y >= 6 || y < 0) {
      return;
    }
    if (map.contains(board[x][y])) {
      return;
    }
    visitAll(board, x - 1, y);
//    if(map.contains(4)) {
//      map.clear();
//    }
    map.add(board[x][y]);
    visitAll(board, x, y + 1);
    map.add(board[x][y]);
    visitAll(board, x, y - 1);
    map.add(board[x][y]);
    visitAll(board, x + 1, y);
    map.add(board[x][y]);

  }




  private static void visitAll(int[][] board, int x, int y) {
    //assuming board size is not more than 5X5
    if (x < 0 || x >= 5 || y >= 5 || y < 0) {
      return;
    }
    // need to handle condition for empty cell and enemy cell
    // if cell is present with enemy then need to clear the path contructed in that direction
    // so for each iteration it is required to store path visited in that particuler iteration
    //if cell is already processed and added to set then no need to process any corresponding neightbours cell(LRTB)
    if (map.contains(board[x][y])) {
      return;
    }
    map.add(board[x][y]);

    visitAll(board, x - 1, y);
    visitAll(board, x, y + 1);
    visitAll(board, x, y - 1);
    visitAll(board, x + 1, y);

  }

}

