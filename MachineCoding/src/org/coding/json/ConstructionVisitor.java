package org.coding.json;

public class ConstructionVisitor implements Visitor<Json> {
  @Override public Json visitString(String value) {
    return new StringJson(value);
  }

  @Override public Json visitNumber(int value) {
    return new NumberJson(value);
  }

  @Override public DictionaryVisitior<Json> visitDictionary() {
    return new ConstructionDictVisitor();
  }
}
