package org.coding.sort;

import java.util.Iterator;

public interface Sorter {
  Iterator<RowBatch>[] sort(Iterator<RowBatch>[] input);
  void close();
}
