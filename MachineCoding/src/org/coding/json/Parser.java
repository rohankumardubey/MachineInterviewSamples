package org.coding.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser<T> {
  private int offset;
  private char DOUBLE_QUOTE = '\"';

  private void skipWhiteSpace(String data) {
    while (Character.isWhitespace(data.charAt(offset))) {
      offset++;
    }
  }

  public static void main(String[] args) throws IOException {
    Parser<Json> parser = new Parser<>();
    BufferedReader reader = new BufferedReader(new FileReader("/home/root1/Desktop/json.txt"));
    final String s = reader.readLine();
    final Json json = parser.internalParser(s, new ConstructionVisitor());
    System.out.println();
  }

  public T internalParser(String input, Visitor<T> visitor) {
    if (input.charAt(offset) == DOUBLE_QUOTE) {
      return visitor.visitString(parseString(input));
    } else if (Character.isDigit(input.charAt(offset))) {
      return visitor.visitNumber(parseNumber(input));
    } else if (input.charAt(offset) == '{') {
      return parseDict(input, visitor.visitDictionary());
    } else {
      return null;
    }
  }

  private String parseString(String input) {
    int start = offset;
    offset += 1;
    while (input.charAt(offset) != DOUBLE_QUOTE) {
      offset += 1;
    }
    offset += 1;
    return input.substring(start + 1, offset - 1);
  }

  private int parseNumber(String input) {
    int start = offset;
    while (Character.isDigit(input.charAt(offset))) {
      offset += 1;
    }
    return Integer.parseInt(input.substring(start, offset));
  }

  private T parseDict(String input, DictionaryVisitior<T> dictionaryVisitior) {
    offset += 1;
    boolean isDone = false;
    while (!isDone) {
      skipWhiteSpace(input);
      String key = parseString(input);
      dictionaryVisitior.visitKey(key);
      skipWhiteSpace(input);
      offset += 1;
      skipWhiteSpace(input);
      T val = internalParser(input, dictionaryVisitior.visitValue());
      dictionaryVisitior.visitValue(val);
      skipWhiteSpace(input);
      if (input.charAt(offset) == '}') {
        isDone = true;
      }
      offset += 1;
    }
    return dictionaryVisitior.done();
  }
}
