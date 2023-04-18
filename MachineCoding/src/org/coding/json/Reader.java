package org.coding.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Reader implements Iterator<Json> {
  private List<Json> currentJsonList;
  private List<Json> backupJsonList;
  private JsonStream jsonStream;
  private ParserStream<Json> parser;
  private int currentIndex;
  private Future<Void> future;
  private ExecutorService executorService;
  private boolean isBackupFilled;
  private boolean isDone;

  public Reader(String filePath) throws IOException {
    jsonStream = new JsonStream(filePath);
    executorService = Executors.newFixedThreadPool(1);
    parser = new ParserStream<>();
    fillBuffer(false);
    future = executorService.submit(new JsonFetcher(true));
  }

  @Override public boolean hasNext() {
    if (currentIndex < currentJsonList.size()) {
      return true;
    } else if (isBackupFilled) {
      fillBackupAndSubmitAsync();
      return true;
    } else {
      if (isDone && !isBackupFilled) {
        executorService.shutdownNow();
        try {
          jsonStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        return false;
      } else {
        try {
          future.get();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (ExecutionException e) {
          e.printStackTrace();
        }
        fillBackupAndSubmitAsync();
        return true;
      }
    }
  }

  private void fillBackupAndSubmitAsync() {
    currentJsonList = backupJsonList;
    currentIndex = 0;
    isBackupFilled = false;
    if (!isDone) {
      future = executorService.submit(new JsonFetcher(true));
    }
  }

  @Override public Json next() {
    return currentJsonList.get(currentIndex++);
  }

  private class JsonFetcher implements Callable<Void> {
    private boolean isBackup;

    public JsonFetcher(boolean isBackup) {
      this.isBackup = isBackup;
    }

    @Override public Void call() throws Exception {
      fillBuffer(isBackup);
      return null;
    }
  }

  private void fillBuffer(boolean isBackup) throws IOException {
    List<Json> jsons = new ArrayList<>();
    while (jsonStream.isAvailable()) {
      jsons.add(parser.internalParser(jsonStream, new ConstructionVisitor()));
    }
    if (jsons.size() > 0) {
      if (isBackup) {
        backupJsonList = jsons;
        isBackupFilled = true;
      } else {
        currentJsonList = jsons;
      }
    }
    if (!jsonStream.isAvailable()) {
      isDone = true;
    }
  }
}
