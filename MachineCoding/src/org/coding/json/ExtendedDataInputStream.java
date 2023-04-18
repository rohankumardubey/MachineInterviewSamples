package org.coding.json;

import java.io.DataInputStream;

public class ExtendedDataInputStream extends DataInputStream {
  /**
   * Creates a DataInputStream that uses the specified
   * underlying InputStream.
   *
   * @param in the specified input stream
   */
  private ExtendedByteArrayInputStream inputStream;

  public ExtendedDataInputStream(ExtendedByteArrayInputStream in) {
    super(in);
    this.inputStream = in;
  }

  public void resetPosition() {
    this.inputStream.resetPosition();
  }

}
