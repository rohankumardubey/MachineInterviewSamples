package org.coding.textlineeditor.command.impl;

import org.coding.textlineeditor.Doc;
import org.coding.textlineeditor.command.Changeable;
import org.coding.textlineeditor.event.CopyDeleteDisplayEvent;
import org.coding.textlineeditor.event.Event;

public class DeleteCommand implements Changeable {
  private Doc doc;
  public DeleteCommand(Doc doc) {
    this.doc = doc;
  }
  @Override public void execute(Event event) {
    CopyDeleteDisplayEvent delete = (CopyDeleteDisplayEvent) event;
    this.doc
        .delete(delete.getStartLineNumber(), delete.getEndLineNumber());
  }
  @Override public void undo() {
    this.doc.applyMomento();
  }
  @Override public void redo() {
    this.doc.unApplyMomento();
  }
}
