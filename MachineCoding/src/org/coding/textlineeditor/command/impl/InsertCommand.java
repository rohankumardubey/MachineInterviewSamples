package org.coding.textlineeditor.command.impl;

import org.coding.textlineeditor.Doc;
import org.coding.textlineeditor.command.Changeable;
import org.coding.textlineeditor.event.Event;
import org.coding.textlineeditor.event.InsertEvent;

public class InsertCommand implements Changeable {
  private Doc doc;

  public InsertCommand(Doc doc) {
    this.doc = doc;
  }

  @Override public void execute(Event event) {
    InsertEvent insertEvent = (InsertEvent) event;
    this.doc.insert(insertEvent.getLineNumber(), insertEvent.getLine());
  }

  @Override public void undo() {
    this.doc.unApplyMomento();
  }

  @Override public void redo() {
    this.doc.applyMomento();
  }
}
