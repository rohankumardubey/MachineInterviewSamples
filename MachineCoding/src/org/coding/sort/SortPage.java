package org.coding.sort;

import java.util.Iterator;

public class SortPage implements Iterator<Row> {
  private int allowedPageSize;
  private RowBatch rowBatch;
  private int addedSize;

  public SortPage(int pageSize) {
    this.allowedPageSize = (pageSize * 95) / 100;
    this.rowBatch = new RowBatch();
  }

  public void addRow(Row row) {
    rowBatch.addRow(row);
    addedSize += row.getSize();
  }

  public boolean canAdd() {
    return addedSize < allowedPageSize;
  }

  @Override public boolean hasNext() {
    return rowBatch.hasNext();
  }

  @Override public Row next() {
    return rowBatch.next();
  }

  public void sort() {
    this.rowBatch.sort();
  }

  public int getSize() {
    return addedSize;
  }
}
