package org.coding.sort;

import java.io.Closeable;
import java.util.Iterator;

public abstract class AbstractDataProcessorStep implements Closeable {
  protected AbstractDataProcessorStep child;
  private boolean closed;

  public AbstractDataProcessorStep(AbstractDataProcessorStep child) {
    this.child = child;
  }

  public abstract Iterator<RowBatch>[] execute();

  public void close() {
    if (!closed) {
      closed = true;
      if (null != child) {
        child.close();
      }
    }
  }
}
