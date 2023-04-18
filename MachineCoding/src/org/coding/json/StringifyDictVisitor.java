package org.coding.json;

import java.util.ArrayList;
import java.util.List;

public class StringifyDictVisitor implements DictionaryVisitior<String> {
  private StringBuilder token;

  public StringifyDictVisitor() {
    token = new StringBuilder();
    token.append("{");
  }

  @Override public void visitKey(String key) {
    if (token.length() > 1) {
      token.append(",");
    }
    token.append("\"" + key + "\"");
    token.append(":");
  }

  @Override public void visitValue(String value) {
    token.append(value);
  }

  @Override public Visitor<String> visitValue() {
    return new StringifyVisitor();
  }

  @Override public String done() {
    token.append("}");
    return token.toString();
  }
}
