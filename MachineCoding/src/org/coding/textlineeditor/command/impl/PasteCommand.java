package org.coding.textlineeditor.command.impl;

import org.coding.textlineeditor.Doc;
import org.coding.textlineeditor.command.Changeable;
import org.coding.textlineeditor.event.Event;
import org.coding.textlineeditor.event.PasteEvent;

public class PasteCommand implements Changeable {
  private Doc doc;
  public PasteCommand(Doc doc) {
    this.doc = doc;
  }
  @Override public void execute(Event event) {
    PasteEvent pasteEvent = (PasteEvent)event;
    this.doc.paste(pasteEvent.getLineNumber());

  }
  @Override public void undo() {
    this.doc.unApplyMomento();
  }

  @Override public void redo() {
    this.doc.applyMomento();
  }
}
