package org.apache.practise.pooling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ObjectPool {

  private int minPoolSize;
  private int maxPoolSize;
  private BlockingQueue<PoolObject> pool;
  private AtomicInteger currentPoolSize;
  private ScheduledExecutorService timeoutSchedulerThreadPool;
  private Set<Object> referencePool;

  private ArrayList<String> referenceName;

  public ObjectPool(int minPoolSize, int maxPoolSize, long maxTimeout) {
    this.minPoolSize = minPoolSize;
    this.maxPoolSize = maxPoolSize;
    this.pool = new PriorityBlockingQueue<>();
    this.currentPoolSize = new AtomicInteger();
    this.referencePool = ConcurrentHashMap.newKeySet();
    this.referenceName = new ArrayList<>();

    for (int i = 0; i < minPoolSize; i++) {
      final Object o = new Object();
      String name = "name"+ new Random().nextInt();
      this.pool.offer(new PoolObject(name,o, System.currentTimeMillis()));
      referencePool.add(o);
      currentPoolSize.getAndIncrement();
      this.referenceName.add(name);
    }
    timeoutSchedulerThreadPool = Executors.newScheduledThreadPool(1);
    timeoutSchedulerThreadPool
        .scheduleAtFixedRate(new TimeoutHandlerWorker(maxTimeout), 1, 1, TimeUnit.SECONDS);
  }

  public Object getObject() throws InterruptedException {
    if (pool.size() == 0 && currentPoolSize.get() < maxPoolSize) {
       currentPoolSize.getAndIncrement();
       return new Object();
    }
    PoolObject obj = null;
    while (obj == null) {
      obj = pool.poll(5, TimeUnit.MILLISECONDS);
//      System.out.println(obj+"time stamp is :"+obj.timestamp);
    }
    referencePool.remove(obj.obj);
    return obj.obj;
  }

  public ArrayList<String> getObjectPoolNames(){
    return this.referenceName;
  }

  public void releaseObject(String name,Object obj) {
    if (null != obj && !referencePool.contains(obj)) {
      // add check for same object
      referencePool.add(obj);
      pool.offer(new PoolObject("name"+ new Random().nextInt(),obj, System.currentTimeMillis()));
    }
  }

  private class TimeoutHandlerWorker implements Runnable {
    private long maxTimeout;

    private TimeoutHandlerWorker(long maxTimeout) {
      this.maxTimeout = maxTimeout;
    }

    @Override public void run() {
      int counter = currentPoolSize.get();
      while (counter > minPoolSize && !pool.isEmpty()) {
        try {
          final PoolObject take = pool.poll(5, TimeUnit.MILLISECONDS);
          if(take==null) {
            break;
          }
          if (!isMaxQueryTimeoutExceeded(take.timestamp)) {
            pool.offer(take);
            break;
          } else {
            counter--;
            referencePool.remove(take.obj);
            currentPoolSize.getAndDecrement();
          }
        } catch (InterruptedException e) {
          break;
        }
      }
    }
    private boolean isMaxQueryTimeoutExceeded(long objTimestamp) {
      long currentTime = System.currentTimeMillis();
      long difference = currentTime - objTimestamp;
      long minutesElapsed = (difference / (1000));
      return minutesElapsed > maxTimeout;
    }
  }

  public void closePool() {
    pool.clear();
    timeoutSchedulerThreadPool.shutdownNow();
  }

  private class PoolObject implements Comparable<PoolObject> {

    private String name;
    private Object obj;
    private long timestamp;

    private PoolObject(String name,Object obj, long timestamp) {
      this.name=name;
      this.obj = obj;
      this.timestamp = timestamp;
    }

    @Override public int compareTo(PoolObject o) {
      long firstDiff = System.currentTimeMillis() - this.timestamp;
      long secondDiff = System.currentTimeMillis() - o.timestamp;
      if (firstDiff < secondDiff) {
        return 1;
      } else if (firstDiff > secondDiff) {
        return -1;
      }
      return 0;
    }

    public String getPoolObjectName(){
      return this.name;
    }
  }
}
