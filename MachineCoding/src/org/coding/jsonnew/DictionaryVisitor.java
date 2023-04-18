package org.coding.jsonnew;

import org.coding.json.DictionaryVisitior;

public interface DictionaryVisitor<T> {
  void visitKey(String key);
  void visitValue(T value);
  DictionaryVisitior<T> visitValue();
  T done();
}
