package org.coding;

import java.util.PriorityQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DelayQueue<E extends Delayed> implements Queue<E> {
  private ReentrantLock lock;
  private Condition condition;
  private PriorityQueue<E> queue;
  private Thread thread;

  public DelayQueue() {
    lock = new ReentrantLock();
    condition = lock.newCondition();
    queue = new PriorityQueue<>();
  }

  @Override public boolean add(E e) {
    lock.lock();
    try {
      queue.offer(e);
      if (queue.peek() == e) {
        thread = null;
        condition.signal();
      }
      return true;
    } finally {
      lock.lock();
    }
  }

  @Override public E peek() {
    lock.lock();
    try {
      return queue.peek();
    } finally {
      lock.unlock();
    }
  }

  @Override public E poll() {
    lock.lock();
    try {
      final E poll = queue.peek();
      if (null == poll || poll.getDelay(TimeUnit.NANOSECONDS) > 0) {
        return null;
      }
      return queue.poll();
    } finally {
      lock.unlock();
    }
  }

  @Override public E take() throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (true) {
        E peek = queue.peek();
        if (peek == null) {
          condition.await();
        } else {
          if (peek.getDelay(TimeUnit.NANOSECONDS) <= 0) {
            return queue.poll();
          }
          if (thread != null) {
            condition.await();
          } else {
            Thread t = Thread.currentThread();
            thread = t;
            try {
              condition.awaitNanos(peek.getDelay(TimeUnit.NANOSECONDS));
            } finally {
              if (thread == t) {
                thread = null;
              }
            }
          }
        }
      }
    } finally {
      if (thread == null && queue.peek() != null) {
        condition.signal();
      }
      lock.unlock();
    }
  }

  @Override public boolean put(E e) throws InterruptedException {
    return add(e);
  }
}
