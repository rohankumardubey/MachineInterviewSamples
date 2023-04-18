package org.apache.practise.machinecoding.textlineeditor.storage;

import java.util.ArrayList;
import java.util.List;

import org.apache.practise.machinecoding.textlineeditor.storage.checkpoint.CheckPointCareTaker;
import org.apache.practise.machinecoding.textlineeditor.storage.checkpoint.Momento;
import org.apache.practise.machinecoding.textlineeditor.storage.internalstorage.DataStore;
import org.apache.practise.machinecoding.textlineeditor.storage.internalstorage.StoreFactory;

public class TextLineStorage {

  private final CheckPointCareTaker checkPointCareTaker;

  private DataStore dataStore;

  private static final String LASTOPERATION = "lastoperation";

  private static final String COPY = "copy";

  public TextLineStorage(CheckPointCareTaker checkPointCareTaker) {
    this.dataStore = StoreFactory.getDataStore();
    this.checkPointCareTaker = checkPointCareTaker;
  }

  public void insert(int lineNumber, String line) {
    insertInternal(lineNumber, line);
    List<Momento> newCheckPointsMomento = new ArrayList<>();
    newCheckPointsMomento.add(new Momento(line, lineNumber));
    this.checkPointCareTaker.saveCheckPoint(LASTOPERATION, newCheckPointsMomento);
  }

  public void insertInternal(int lineNumber, String line) {
    this.dataStore.insert(lineNumber, line);
  }

  public void delete(int startLineNumber, int endLineNumber) {
    for (int i = startLineNumber; i < endLineNumber; i++) {
      this.deleteInternal(i);
    }
  }

  private void deleteInternal(int lineNumber) {
    this.dataStore.delete(lineNumber);
  }

  public void copy(int startLineNumber, int endLineNumber) {
    List<Momento> momentos = new ArrayList<>();
    for (int i = startLineNumber; i <= endLineNumber; i++) {
      String line = this.dataStore.get(startLineNumber);
      Momento momento = new Momento(line, -1);
      momentos.add(momento);
    }
    this.checkPointCareTaker.saveCheckPoint(COPY, momentos);
  }

  public void paste(int lineNumber) {
    final List<Momento> copied = checkPointCareTaker.getCheckPoint(COPY);
    List<Momento> newCheckPointsMomento = new ArrayList<>();
    if (null != copied) {
      for (Momento m : copied) {
        insertInternal(lineNumber, m.getLine());
        newCheckPointsMomento.add(new Momento(m.getLine(), lineNumber));
        lineNumber++;
      }
    }
    checkPointCareTaker.saveCheckPoint(LASTOPERATION, newCheckPointsMomento);
  }

  public void undo() {

  }

  public void redo() {
  }
}

