package org.coding.textlineeditor.command;

import org.coding.textlineeditor.Doc;
import org.coding.textlineeditor.MomentoCaretaker;
import org.coding.textlineeditor.command.impl.CopyCommand;
import org.coding.textlineeditor.command.impl.DeleteCommand;
import org.coding.textlineeditor.command.impl.DisplayCommand;
import org.coding.textlineeditor.command.impl.InsertCommand;
import org.coding.textlineeditor.command.impl.PasteCommand;
import org.coding.textlineeditor.event.CopyDeleteDisplayEvent;
import org.coding.textlineeditor.event.InsertEvent;
import org.coding.textlineeditor.event.PasteEvent;

public class Editor {
  private Doc doc;
  private MomentoCaretaker momentoCaretaker;
  private Changeable changeable;

  public Editor() {
    this.momentoCaretaker = new MomentoCaretaker();
    this.doc = new Doc(this.momentoCaretaker);
  }

  public void insert(int lineNumber, String line) {
    Command insertCommand = new InsertCommand(doc);
    insertCommand.execute(new InsertEvent(lineNumber, line));
    this.changeable = (Changeable) insertCommand;
  }

  public void copy(int start, int end) {
    Command copyCommand = new CopyCommand(doc);
    copyCommand.execute(new CopyDeleteDisplayEvent(start, end));
  }

  public void paste(int lineNumber) {
    Command pasteCommand = new PasteCommand(doc);
    pasteCommand.execute(new PasteEvent(lineNumber));
    this.changeable = (Changeable) pasteCommand;
  }

  public void undo() {
    if (null != changeable) {
      this.changeable.undo();
    }
  }

  public void redo() {
    if (null != changeable) {
      this.changeable.redo();
    }
  }

  public void delete(int lineNumber) {
    delete(lineNumber, lineNumber);
  }

  public void delete(int start, int end) {
    Command deleteCommand = new DeleteCommand(doc);
    deleteCommand.execute(new CopyDeleteDisplayEvent(start, end));
    this.changeable = (Changeable) deleteCommand;
  }

  public void display() {
    display(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public void display(int start, int end) {
    Command displayCommand = new DisplayCommand(doc);
    displayCommand.execute(new CopyDeleteDisplayEvent(start, end));
  }
}
