package org.coding;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> implements Queue<E> {
  private Object[] data;
  private int getIndex;
  private int putIndex;
  private ReentrantLock lock;
  private Condition noFull;
  private Condition noEmpty;
  private int size;

  public BlockingQueue(int size) {
    this.lock = new ReentrantLock();
    this.data = new Object[size];
    this.noFull = lock.newCondition();
    this.noEmpty = lock.newCondition();
  }

  @Override public boolean add(E e) {
    if (e == null) {
      throw new NullPointerException();
    }
    lock.lock();
    try {
      if (size == this.data.length) {
        return false;
      }
      this.data[putIndex] = e;
      if (++putIndex == data.length) {
        putIndex = 0;
      }
      size++;
      noEmpty.signal();
      return true;
    } finally {
      lock.unlock();
    }
  }

  @Override public E peek() {
    lock.lock();
    try {
      if (size == 0) {
        return null;
      }
      return (E) data[getIndex];
    } finally {
      lock.unlock();
    }
  }

  @Override public E poll() {
    lock.lock();
    try {
      if (size == 0) {
        return null;
      }
      E poll = (E) data[getIndex];
      data[getIndex] = null;
      if (++getIndex == data.length) {
        getIndex = 0;
      }
      size--;
      noFull.signal();
      return poll;
    } finally {
      lock.unlock();
    }
  }

  @Override public E take() throws InterruptedException {
    lock.lockInterruptibly();
    try {
      if (size == 0) {
        noEmpty.await();
      }
      E take = (E) data[getIndex];
      data[getIndex] = null;
      if (++getIndex == data.length) {
        getIndex = 0;
      }
      size--;
      noFull.signal();
      return take;
    } finally {
      lock.unlock();
    }
  }

  @Override public boolean put(E e) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      if(size==data.length) {
        noFull.await();
      }
      data[putIndex] = e;
      if(++putIndex == data.length) {
        putIndex = 0;
      }
      size++;
      noEmpty.signal();
      return true;
    } finally {
      lock.unlock();
    }
  }
}
