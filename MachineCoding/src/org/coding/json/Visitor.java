package org.coding.json;

public interface Visitor<T> {
  T visitString(String value);
  T visitNumber(int value);
  DictionaryVisitior<T> visitDictionary();
}
