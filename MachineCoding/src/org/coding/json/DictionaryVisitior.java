package org.coding.json;

public interface DictionaryVisitior<T> {
  void visitKey(String key);
  void visitValue(T value);
  Visitor<T> visitValue();
  T done();
}
