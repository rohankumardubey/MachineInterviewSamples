package org.coding.json;

import java.io.ByteArrayInputStream;

public class ExtendedByteArrayInputStream extends ByteArrayInputStream {

  public ExtendedByteArrayInputStream(byte[] buf, int offset, int len) {
    super(buf, offset, len);
  }

  public void resetPosition() {
    pos = pos - 1;
  }

}
