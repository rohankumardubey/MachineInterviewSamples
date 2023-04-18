package org.apache.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolQueue {
  private Map<Connection, Long> connectionLongMap;
  private BlockingQueue<Connection> pool;
  private AtomicInteger currentPoolSize;
  private int maxPoolSize;
  private String url;
  private String userId;
  private String password;
  private int minPoolSize;

  public ConnectionPoolQueue(int minPoolSize, String url, String userId, String password,
      int maxTimeout, int maxPoolSize) throws SQLException {
    this.userId = userId;
    this.url = url;
    this.password = password;
    pool = new LinkedBlockingQueue<>(maxPoolSize);
    this.connectionLongMap = new ConcurrentHashMap<>();
    for (int i = 0; i < minPoolSize; i++) {
      final Connection connection = createConnection();
      pool.offer(connection);
      connectionLongMap.put(connection, System.currentTimeMillis());
      currentPoolSize.getAndIncrement();
    }
    this.maxPoolSize = maxPoolSize;
    this.minPoolSize = minPoolSize;
    ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
    ses.scheduleAtFixedRate(new ConnectionPoolTimeout(maxTimeout), 30, 60, TimeUnit.SECONDS);
  }

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection(url, userId, password);
  }

  public Connection getConnection() throws SQLException, InterruptedException {
    if (pool.size() == 0 && currentPoolSize.get() < maxPoolSize) {
      currentPoolSize.getAndIncrement();
      return createConnection();
    }
    Connection connection = null;
    while (connection == null) {
      connection = pool.poll(5, TimeUnit.SECONDS);
      connectionLongMap.remove(connection);
    }
    return connection;
  }

  public void releaseConnection(Connection con) {
    if (null != con) {
      pool.offer(con);
      connectionLongMap.put(con, System.currentTimeMillis());
    }
  }

  private static class ConnectionPoolTimeout implements Runnable {
    private int maxTimeout;

    private ConnectionPoolTimeout(int maxTimeout) {
      this.maxTimeout = maxTimeout;
    }

    @Override public void run() {

    }

    private boolean isMaxQueryTimeoutExceeded(long fileTimestamp) {
      long currentTime = System.currentTimeMillis();
      long difference = currentTime - fileTimestamp;
      long minutesElapsed = (difference / (1000 * 60));
      return minutesElapsed > maxTimeout;
    }
  }
}
