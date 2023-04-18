package org.coding.textlineeditor.command;

import org.coding.textlineeditor.event.Event;

public interface Command {
  void execute(Event event);
}
