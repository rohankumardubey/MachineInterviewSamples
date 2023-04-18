package org.coding.pubbrokersub;

import java.io.Closeable;

public interface Producer<K,V> extends Closeable {
  void send(Producer<K,V> record);
}
