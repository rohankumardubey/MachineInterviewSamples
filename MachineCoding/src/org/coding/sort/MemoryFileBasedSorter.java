package org.coding.sort;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MemoryFileBasedSorter {

  private List<SortPage> inMemoryPage;

  private final Object lock;

  private ExecutorService sortExecutorService;

  private SortPage sortPage;

  private int maxPageSize;
  private int maxMemorySize;
  private String tempLocation;
  private Semaphore semaphore;

  public MemoryFileBasedSorter(int maxPageSize, int maxMemorySize, String tempLocation,
      List<SortPage> inMemoryPage) {
    this.inMemoryPage = inMemoryPage;
    this.lock = new Object();
    this.sortExecutorService = Executors.newFixedThreadPool(5);
    semaphore = new Semaphore(5);
    this.maxPageSize = maxPageSize;
    this.maxMemorySize = maxMemorySize;
    this.sortPage = new SortPage(maxPageSize);
    this.tempLocation = tempLocation;
  }

  public void addRow(Row row) {
    if (sortPage.canAdd()) {
      sortPage.addRow(row);
    } else {
      try {
        semaphore.acquire();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      sortExecutorService.submit(new SorterAndWriterThread(sortPage));
      sortPage = new SortPage(maxPageSize);
    }
  }

  public void startSorting() {
    if (sortPage.getSize() > 0) {
      sortPage.sort();
      inMemoryPage.add(sortPage);
    }
  }

  private class SorterAndWriterThread implements Callable<Void> {
    private SortPage sortPage;

    private SorterAndWriterThread(SortPage sortPage) {
      this.sortPage = sortPage;
    }

    @Override public Void call() throws Exception {
      sortPage.sort();
      if ((inMemoryPage.size() * maxPageSize) + maxPageSize <= maxMemorySize) {
        inMemoryPage.add(sortPage);
      } else {
        DataOutputStream outputStream = null;
        File file = new File(tempLocation + "/" + System.nanoTime());
        try {
          outputStream = new DataOutputStream(new FileOutputStream(file));
          outputStream.writeInt(sortPage.getSize());
          while (sortPage.hasNext()) {
            final Row next = sortPage.next();
            final byte[][] row = next.getRow();
            outputStream.writeInt(row.length);
            for (byte[] r : row) {
              outputStream.writeInt(r.length);
              outputStream.write(r);
            }
          }
        } catch(Exception e) {
          semaphore.release();
          throw e;
        }finally {
          if (null != outputStream) {
            outputStream.close();
          }
          semaphore.release();
        }
      }
      return null;
    }
  }
}
