package org.coding.sort;

import java.util.Iterator;

public class SortAndMergeStep extends AbstractDataProcessorStep {
  private Sorter sorter;

  public SortAndMergeStep(AbstractDataProcessorStep child) {
    super(child);
    this.sorter = new ParallelSorter();
  }

  @Override public Iterator<RowBatch>[] execute() {
    final Iterator<RowBatch>[] execute = child.execute();
    return this.sorter.sort(execute);
  }
}
