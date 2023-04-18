package org.coding.textlineeditor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.coding.textlineeditor.datastore.DataStore;
import org.coding.textlineeditor.datastore.StoreFactory;

public class Doc {

  private DataStore dataStore;

  private MomentoCaretaker momentoCaretaker;

  public Doc(MomentoCaretaker momentoCaretaker) {
    this.dataStore = StoreFactory.getDataStore();
    this.momentoCaretaker = momentoCaretaker;
  }

  public void insert(int lineNumber, String line) {
    this.dataStore.insert(lineNumber, line);
    List<Momento> momentoList = new ArrayList<>();
    momentoList.add(new Momento(lineNumber, line));
    this.momentoCaretaker.saveCheckpoint("lastoperation", momentoList);
  }

  public void delete(int startline, int endline) {
    List<Momento> momentoList = new ArrayList<>();
    for (int i = startline; i <= endline; i++) {
      final String delete = this.dataStore.delete(i);
      if (null != delete) {
        momentoList.add(new Momento(i, delete));
      }
    }
    this.momentoCaretaker.saveCheckpoint("lastoperation", momentoList);
  }

  public void paste(int lineNumber) {
    final List<Momento> copy = this.momentoCaretaker.getCheckpoint("copy");
    List<Momento> momentoList = new ArrayList<>();
    for (Momento m : copy) {
      this.dataStore.insert(++lineNumber, m.getLine());
      momentoList.add(new Momento(++lineNumber, m.getLine()));
    }
    this.momentoCaretaker.saveCheckpoint("lastoperation", momentoList);
  }

  public void copy(int startline, int endline) {
    List<Momento> momentoList = new ArrayList<>();
    for (int i = startline; i <= endline; i++) {
      final String s = this.dataStore.get(i);
      if (null != s) {
        momentoList.add(new Momento(-1, s));
      }
    }
    this.momentoCaretaker.saveCheckpoint("copy", momentoList);
  }

  public void display() {
    final Iterator<String> iterator = this.dataStore.getIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  public void display(int start, int end) {
    for (int i = start; i <=end; i++) {
      System.out.println(this.dataStore.get(i));
    }
  }

  public void applyMomento() {
    final List<Momento> momentoList = this.momentoCaretaker.getCheckpoint("lastOperation");
    for (Momento m : momentoList) {
      this.dataStore.insert(m.getLineNumber(), m.getLine());
    }
  }

  public void unApplyMomento() {
    final List<Momento> momentoList = this.momentoCaretaker.getCheckpoint("lastOperation");
    for (Momento m : momentoList) {
      this.dataStore.delete(m.getLineNumber());
    }
  }
}
