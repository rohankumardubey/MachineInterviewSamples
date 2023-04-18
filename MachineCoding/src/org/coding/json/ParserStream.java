package org.coding.json;

import java.io.IOException;

public class ParserStream<T> {
  private char DOUBLE_QUOTE = '\"';
  private char JSON_START = '{';
  private char JSON_END = '}';

  public T internalParser(JsonStream input, Visitor<T> visitor) throws IOException {
    if (input.isChar(DOUBLE_QUOTE)) {
      return visitor.visitString(input.getString());
    } else if (input.isDigit()) {
      return visitor.visitNumber(input.getNumber());
    } else if (input.isChar(JSON_START)) {
      return parseDict(input, visitor.visitDictionary());
    } else {
      throw new RuntimeException("Invalid Json String");
    }
  }

  private T parseDict(JsonStream input, DictionaryVisitior<T> dictionaryVisitior)
      throws IOException {
    input.skipChar();
    boolean isDone = false;
    while (!isDone) {
      input.skipEmpty();
      String key = input.getString();
      dictionaryVisitior.visitKey(key);
      input.skipEmpty();
      input.skipChar();
      input.skipEmpty();
      T val = internalParser(input, dictionaryVisitior.visitValue());
      dictionaryVisitior.visitValue(val);
      input.skipEmpty();
      if (input.isChar(JSON_END)) {
        isDone = true;
      }
      input.skipChar();
    }
    return dictionaryVisitior.done();
  }
}
