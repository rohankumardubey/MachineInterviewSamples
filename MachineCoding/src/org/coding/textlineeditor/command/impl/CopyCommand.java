package org.coding.textlineeditor.command.impl;

import org.coding.textlineeditor.Doc;
import org.coding.textlineeditor.command.Command;
import org.coding.textlineeditor.event.CopyDeleteDisplayEvent;
import org.coding.textlineeditor.event.Event;

public class CopyCommand implements Command {
  private Doc doc;

  public CopyCommand(Doc doc) {
    this.doc = doc;
  }

  @Override public void execute(Event event) {
    CopyDeleteDisplayEvent copyEvent = (CopyDeleteDisplayEvent) event;
    this.doc
        .copy(copyEvent.getStartLineNumber(), copyEvent.getEndLineNumber());
  }
}
