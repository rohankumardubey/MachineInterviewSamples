package org.apache.practise.machinecoding.textlineeditor;

public interface TextLineEditor {
  void insert(String line, long position);

  void delete(int start, int end);

  void delete(int end);

  void display(int start, int end);

  void display();

  void copy(int start, int end);

  void paste(long position);
}
