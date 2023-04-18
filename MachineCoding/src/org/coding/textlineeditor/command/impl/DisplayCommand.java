package org.coding.textlineeditor.command.impl;

import org.coding.textlineeditor.Doc;
import org.coding.textlineeditor.command.Command;
import org.coding.textlineeditor.event.CopyDeleteDisplayEvent;
import org.coding.textlineeditor.event.Event;

public class DisplayCommand implements Command {
  private Doc doc;

  public DisplayCommand(Doc doc) {
    this.doc = doc;
  }

  @Override public void execute(Event event) {
    CopyDeleteDisplayEvent displayEvent = (CopyDeleteDisplayEvent) event;
    if (displayEvent.getStartLineNumber() == Integer.MIN_VALUE
        && displayEvent.getEndLineNumber() == Integer.MAX_VALUE) {
      doc.display();
    } else {
      doc.display(displayEvent.getStartLineNumber(), displayEvent.getEndLineNumber());
    }
  }
}
