package org.apache.practise.designproblems;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUConcurrent {
  private final int capacity;
  private Queue<Integer> queue;
  private Map<Integer, Integer> map;
  private Lock readLock;
  private Lock writeLock;

  public LRUConcurrent(int capacity) {
    this.capacity = capacity;
    this.queue = new ConcurrentLinkedQueue<>();
    this.map = new ConcurrentHashMap<>();
    ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    this.readLock = reentrantReadWriteLock.readLock();
    this.writeLock = reentrantReadWriteLock.writeLock();
  }

  public void put(int key, int value) {
    this.writeLock.unlock();
    try {
      if (map.containsKey(key)) {
        queue.remove();
      } else if (queue.size() == capacity) {
        final Integer poll = queue.poll();
        map.remove(poll);
      }
      queue.add(key);
      map.put(key, value);
    } finally {
      this.writeLock.unlock();
    }
  }

  public Integer get(int key) {
    this.readLock.lock();
    Integer integer = null;
    try {
      integer = map.get(key);
      if (integer != null) {
        queue.remove(integer);
        queue.add(key);
      }
    } finally {
      this.readLock.unlock();
    }
    return integer;
  }
}
