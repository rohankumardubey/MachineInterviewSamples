package org.coding.jsonnew.json;

import java.io.IOException;

import org.coding.json.DictionaryVisitior;
import org.coding.json.JsonStream;
import org.coding.json.Visitor;

public class ParserStream<T> {
  private char DOUBLE_QUOTE = '\"';
  private char JSON_START = '{';
  private char JSON_END = '}';

  public T parse(JsonStream stream, Visitor<T> visitor) throws IOException {
    if (stream.isChar(DOUBLE_QUOTE)) {
      return visitor.visitString(stream.getString());
    } else if (stream.isDigit()) {
      return visitor.visitNumber(stream.getNumber());
    } else if (stream.isChar(JSON_START)) {
      return parseDictionary(stream, visitor.visitDictionary());
    } else {
      throw new RuntimeException("Invalid Json Exception");
    }
  }

  private T parseDictionary(JsonStream jsonStream, DictionaryVisitior<T> dictionaryVisitior)
      throws IOException {
    jsonStream.skipChar();
    boolean isDone = false;
    while (!isDone) {
      jsonStream.skipEmpty();
      dictionaryVisitior.visitKey(jsonStream.getString());
      jsonStream.skipEmpty();
      jsonStream.skipChar();
      final T value = parse(jsonStream, dictionaryVisitior.visitValue());
      dictionaryVisitior.visitValue(value);
      jsonStream.skipEmpty();
      if (jsonStream.isChar(JSON_END)) {
        isDone = true;
      }
      jsonStream.skipChar();
    }
    return dictionaryVisitior.done();
  }
}
