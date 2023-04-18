package org.apache.cache;

public interface Cacheable {
  int accessCount();
  void invalidate();
  long memorySize();
}
