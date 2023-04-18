package org.coding.textlineeditor.command;

public interface Changeable extends Command {
  void undo();
  void redo();
}
