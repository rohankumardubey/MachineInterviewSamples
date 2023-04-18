package org.coding.sort;

public class Row implements Comparable<Row> {
  private byte[][] rows;
  private int size;

  public Row(byte[][] rows) {
    this.rows = rows;
    for (byte[] row : rows) {
      size += row.length;
    }
  }

  public byte[][] getRow() {
    return rows;
  }

  public int getSize() {
    return size;
  }

  @Override public int compareTo(Row o) {

    return 0;
  }
}
