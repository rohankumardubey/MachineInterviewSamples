package org.coding.json;

public class StringifyVisitor implements Visitor<String> {
  @Override public String visitString(String value) {
    return "\"" + value + "\"";
  }
  @Override public String visitNumber(int value) {
    return value + "";
  }
  @Override public DictionaryVisitior<String> visitDictionary() {
    return new StringifyDictVisitor();
  }
}
