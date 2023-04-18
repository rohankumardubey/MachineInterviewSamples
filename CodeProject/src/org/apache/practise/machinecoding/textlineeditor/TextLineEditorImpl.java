package org.apache.practise.machinecoding.textlineeditor;

import org.apache.practise.machinecoding.textlineeditor.events.CopyDeleteEvent;
import org.apache.practise.machinecoding.textlineeditor.events.InsertEvent;
import org.apache.practise.machinecoding.textlineeditor.events.PasteEvent;
import org.apache.practise.machinecoding.textlineeditor.operationlisteners.OperationEventListenerBus;
import org.apache.practise.machinecoding.textlineeditor.operationlisteners.impl.CopyOperationListener;
import org.apache.practise.machinecoding.textlineeditor.operationlisteners.impl.DeleteOperationListener;
import org.apache.practise.machinecoding.textlineeditor.operationlisteners.impl.InsertOperationListener;
import org.apache.practise.machinecoding.textlineeditor.operationlisteners.impl.PasteOperationListener;

public class TextLineEditorImpl implements TextLineEditor {

  private OperationEventListenerBus operationEventListenerBus;

  public TextLineEditorImpl() {
    operationEventListenerBus = OperationEventListenerBus.getInstance();
  }

  private void addOperationListener() {
    operationEventListenerBus.addListener(InsertEvent.class, new InsertOperationListener());
    operationEventListenerBus.addListener(CopyDeleteEvent.class, new DeleteOperationListener());
    operationEventListenerBus.addListener(CopyDeleteEvent.class, new CopyOperationListener());
    operationEventListenerBus.addListener(PasteEvent.class, new PasteOperationListener());
  }

  @Override public void insert(String line, long position) {
    operationEventListenerBus.fireEvent(new InsertEvent(line, position));
  }

  @Override public void delete(int start, int end) {

  }

  @Override public void delete(int end) {

  }

  @Override public void display(int start, int end) {

  }

  @Override public void display() {

  }

  @Override public void copy(int start, int end) {

  }

  @Override public void paste(long position) {
    operationEventListenerBus.fireEvent(new PasteEvent(position));
  }
}
