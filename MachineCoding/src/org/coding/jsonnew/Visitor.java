package org.coding.jsonnew;

public interface Visitor<T> {
  T visitiString(String str);
  T visitNumber(int number);
  DictionaryVisitor<T> visitDictionary();
}
