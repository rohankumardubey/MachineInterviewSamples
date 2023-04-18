package org.coding.sort;

import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;

public class InputStep extends AbstractDataProcessorStep {
  private String folderPath;
  private boolean isHeaderPresent;

  public InputStep(String folderPath, boolean isHeaderPresent) {
    super(null);
    this.folderPath = folderPath;
    this.isHeaderPresent = isHeaderPresent;
  }

  @Override public Iterator<RowBatch>[] execute() {
    File file = new File(folderPath);
    File[] filePaths = file.listFiles(new FileFilter() {
      @Override public boolean accept(File pathname) {
        return pathname.getName().endsWith("csv");
      }
    });
    Iterator<RowBatch>[] iterator = new Iterator[filePaths.length];
    int counter = 0;
    for (File f : filePaths) {
      iterator[counter++] = new MyReader(f.getAbsolutePath(), isHeaderPresent);
    }
    return iterator;
  }
}
