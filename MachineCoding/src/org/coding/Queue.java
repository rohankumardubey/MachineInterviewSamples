package org.coding;

public interface Queue<E> {
  boolean add(E e);
  E peek();
  E poll();
  E take() throws InterruptedException;
  boolean put(E e) throws InterruptedException;
}
