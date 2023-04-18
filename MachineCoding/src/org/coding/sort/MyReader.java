package org.coding.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyReader implements Iterator<RowBatch> {
  private BufferedReader reader;
  private Row[] currentBuffer;
  private Row[] backupBuffer;
  private boolean isDone;
  private ExecutorService executorService;
  private Future<Void> future;
  private boolean isBackupFilled;

  public MyReader(String fileName, boolean isHeader) {
    this.currentBuffer = new Row[100];
    this.backupBuffer = new Row[100];
    this.executorService = Executors.newFixedThreadPool(1);
  }

  private void initialize(String fileName, boolean isHeader) throws IOException {
    this.reader = new BufferedReader(new FileReader(fileName));
    if (isHeader) {
      this.reader.readLine();
    }
    fillBuffer(false);
    future = executorService.submit(new DataFetcher(true));
  }

  @Override public boolean hasNext() {
    if (isDone) {
      return false;
    } else {
      if (!isBackupFilled) {
        try {
          future.get();
        } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
        }
      }
      currentBuffer = backupBuffer;
      isBackupFilled = false;
      if (!isDone) {
        future = executorService.submit(new DataFetcher(true));
      }
      return true;
    }
  }

  @Override public RowBatch next() {
//    return new RowBatch(currentBuffer);
    return null;
  }

  private void fillBuffer(boolean isBackupFilling) throws IOException {
    String[] buffer = new String[100];
    int counter = 0;
    String s = "";
    while (counter < buffer.length && (s = reader.readLine()) != null) {
      buffer[counter++] = s;
    }
    if (counter < buffer.length) {
      isDone = true;
    }
    if (isDone) {
      String[] latestBuffer = new String[counter];
      System.arraycopy(buffer, 0, latestBuffer, 0, latestBuffer.length);
      buffer = latestBuffer;
    }
    fillBuffer(isBackupFilling ? backupBuffer : currentBuffer, buffer);
  }

  private void fillBuffer(Row[] buffer, String[] data) {
    int counter = 0;
    for (String s : data) {
      final String[] split = s.split(",");
      byte[][] bData = new byte[split.length][];
      int c = 0;
      for (String sp : split) {
        bData[c++] = sp.getBytes();
      }
      buffer[counter++] = new Row(bData);
    }
  }

  private class DataFetcher implements Callable<Void> {
    private boolean isBackupFill;

    private DataFetcher(boolean isBackupFill) {
      this.isBackupFill = isBackupFill;
    }

    @Override public Void call() throws Exception {
      fillBuffer(isBackupFill);
      return null;
    }
  }
}
