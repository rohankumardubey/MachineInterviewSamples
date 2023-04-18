package org.coding.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RowBatch implements Iterator<Row> {
  private List<Row> rows;
  private int counter;
  private int batchSize;

  public RowBatch(List<Row> rows) {
    this.rows = rows;
    for (Row r : rows) {
      batchSize += r.getSize();
    }
  }

  public RowBatch() {
    this.rows = new ArrayList<>();
  }

  public void addRow(Row row) {
    this.rows.add(row);
    batchSize += row.getSize();
  }

  @Override public boolean hasNext() {
    return counter < rows.size();
  }

  @Override public Row next() {
    return rows.get(counter++);
  }

  public int getSize() {
    return rows.size();
  }

  public int getDataSize() {
    return batchSize;
  }

  public void sort() {
    Collections.sort(rows);
  }
}
