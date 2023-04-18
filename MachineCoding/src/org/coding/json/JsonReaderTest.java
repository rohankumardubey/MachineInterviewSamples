package org.coding.json;

import java.io.IOException;

public class JsonReaderTest {
  public static void main(String[] args) throws IOException {
    Reader reader = new Reader("/home/root1/Desktop/json.txt");
    while(reader.hasNext()) {
      final Json next = reader.next();
      System.out.println();
    }
  }
}
