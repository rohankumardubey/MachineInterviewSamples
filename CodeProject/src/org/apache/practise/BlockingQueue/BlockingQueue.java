package org.apache.practise.BlockingQueue;

public class BlockingQueue<T> {
  private int capacity;
  private T[] items;
  private int head;
  private int tail;
  private int size;

  public BlockingQueue(int capacity) {
    this.capacity = capacity;
    items = (T[]) new Object[capacity];
  }

  public void offer(T item) throws InterruptedException {
    if (size == capacity) {
      wait();
    }

    if (tail == capacity) {
      tail = 0;
    }
    items[tail] = item;
    size++;
    tail++;
    notifyAll();
  }

  public T take() throws InterruptedException {
    if (size == 0) {
      wait();
    }
    if (head == capacity) {
      head = 0;
    }
    T item = items[head];
    items[head] = null;
    head++;
    size--;
    notifyAll();
    return item;
  }

}
