package org.coding.json;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JsonStream {
  private InputStream stream;
  private byte[] data;
  private ExtendedDataInputStream dataInputStream;
  private char DOUBLE_QUOTE = '\"';
  private long fileSize;
  private long currentRead;

  public JsonStream(String filePath) throws IOException {
    this.data = new byte[10 * 1024 * 1024];
    File file = new File(filePath);
    if (!file.exists()) {
      throw new RuntimeException("Invalid file path");
    }
    this.fileSize = file.length();
    try {
      this.stream = new BufferedInputStream(new FileInputStream(file));
    } catch (FileNotFoundException e) {
      // no required
    }
    readData();
  }

  public boolean isAvailable() throws IOException {
    if(fileSize>currentRead) {
      return true;
    } else {
      return dataInputStream.available()>1;
    }
  }
  private void readData() throws IOException {
    final int read = this.stream.read(data, 0, data.length);
    if (null != dataInputStream) {
      dataInputStream.close();
    }
    currentRead+=read;
    this.dataInputStream =
        new ExtendedDataInputStream(new ExtendedByteArrayInputStream(data, 0, read));
  }

  public void skipEmpty() throws IOException {
    if (dataInputStream.available() <= 1) {
      readData();
    }
    while (Character.isWhitespace((char) dataInputStream.readByte())) {
      if (dataInputStream.available() <= 1) {
        readData();
      }
    }
    dataInputStream.resetPosition();
  }

  public int getNumber() throws IOException {
    if (dataInputStream.available() <= 1) {
      readData();
    }
    StringBuilder stringBuilder = new StringBuilder();
    char c = (char) dataInputStream.readByte();
    while (Character.isDigit(c)) {
      stringBuilder.append(c);
      if (dataInputStream.available() <= 1) {
        readData();
      }
      c = (char) dataInputStream.readByte();
    }
    dataInputStream.resetPosition();
    return Integer.parseInt(stringBuilder.toString());
  }

  public String getString() throws IOException {
    if (dataInputStream.available() <= 1) {
      readData();
    }
    dataInputStream.readByte();
    StringBuilder stringBuilder = new StringBuilder();
    char c = (char) dataInputStream.readByte();
    while (c != DOUBLE_QUOTE) {
      stringBuilder.append(c);
      if (dataInputStream.available() <= 1) {
        readData();
      }
      c = (char) dataInputStream.readByte();
    }
    return stringBuilder.toString();
  }

  public char skipChar() throws IOException {
    return (char) dataInputStream.readByte();
  }

  private char getChar() throws IOException {
    char c = (char) dataInputStream.readByte();
    dataInputStream.resetPosition();
    return c;
  }

  public boolean isChar(char c) throws IOException {
    return getChar() == c;
  }

  public boolean isDigit() throws IOException {
    final char aChar = getChar();
    return Character.isDigit(aChar);
  }

  public void close() throws IOException {
    if(null!=stream) {
      stream.close();
    }
    if(null!=dataInputStream) {
      dataInputStream.close();
    }
  }
}
