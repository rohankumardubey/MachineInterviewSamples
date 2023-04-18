package org.coding.jsonnew.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.coding.json.Parser;

public class JsonReader implements Iterator<Json> {
  private BufferedReader reader;
  private List<Json> currentBuffer;
  private List<Json> backupBuffer;
  private boolean isDone;
  private int currentIndex;
  private ExecutorService executorService;
  private Parser<Json> jsonParser;
  private boolean isBackupFilled;
  public JsonReader(String filePath) throws FileNotFoundException {
    this.reader = new BufferedReader(new FileReader(filePath));
    this.currentBuffer = new ArrayList<>();
    this.backupBuffer = new ArrayList<>();
    this.jsonParser = new Parser<>();
    this.executorService = Executors.newFixedThreadPool(1);
  }

  @Override public boolean hasNext() {
    return false;
  }

  @Override public Json next() {
    return currentBuffer.get(currentIndex++);
  }


  private void fetchAndFillData(boolean isBackupFilling) {

  }
}
