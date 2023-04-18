package org.apache.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {
  private Map<Connection, Long> connectionLongMap;
  private Set<Connection> availableConnections;
  private Set<Connection> usedConnections;
  private int currentPoolSize;
  private int maxPoolSize;
  private String url;
  private String userId;
  private String password;

  public ConnectionPool(int minPoolSize, String url, String userId, String password, int maxTimeout) throws SQLException {
    this.userId = userId;
    this.url = url;
    this.password = password;
    for (int i = 0; i < minPoolSize; i++) {
      final Connection connection = createConnection();
      availableConnections.add(connection);
      connectionLongMap.put(connection, System.currentTimeMillis());
      currentPoolSize++;
    }
    ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
    ses.scheduleAtFixedRate(new ConnectionPoolTimeout(maxTimeout), 30, 60, TimeUnit.SECONDS);
  }

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection(url, userId, password);
  }

  public synchronized Connection getConnection() throws SQLException {
    if (availableConnections.size() == 0) {
      final Connection connection = createConnection();
      availableConnections.add(connection);
      connectionLongMap.put(connection, System.currentTimeMillis());
    }
    Connection con = availableConnections.iterator().next();
    availableConnections.remove(con);
    connectionLongMap.remove(con);
    usedConnections.add(con);
    return con;
  }

  public synchronized boolean releaseConnection(Connection con) {
    if (null != con) {
      usedConnections.remove(con);
      availableConnections.add(con);
      connectionLongMap.put(con, System.currentTimeMillis());
      return true;
    }
    return false;
  }

  public synchronized void removeAndCloseConnection(Connection connection) throws SQLException {
    if (connection != null) {
      final Long currentTime = connectionLongMap.get(connection);
      if (null != currentTime) {
        connectionLongMap.remove(connection);
        availableConnections.remove(connection);
        connection.close();
        currentPoolSize--;
      }
    }
  }

  public synchronized boolean isConnectionAvailable() {
    return availableConnections.size()>0;
  }

  public synchronized int getCurrentPoolSize() {
    return currentPoolSize;
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
