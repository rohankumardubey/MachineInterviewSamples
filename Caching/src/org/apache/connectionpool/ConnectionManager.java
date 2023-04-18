package org.apache.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConnectionManager {
  private static ConnectionManager INSTANCE;
  private ConnectionPool pool;
  private int maxPoolSize;
  private BlockingQueue<Object> request;
  private ConnectionManager(){
    try {
      pool = new ConnectionPool(5, "", "", "", 60);
    } catch (SQLException e) {
    }
  }

  public static ConnectionManager getINSTANCE() {
    if(null==INSTANCE) {
      synchronized (ConnectionManager.class) {
        if(null==INSTANCE) {
          INSTANCE = new ConnectionManager();
        }
      }
    }
    return INSTANCE;
  }

  public Connection getConnection() throws SQLException, InterruptedException {
    synchronized (this) {
      if (pool.isConnectionAvailable() || pool.getCurrentPoolSize()<maxPoolSize) {
        return pool.getConnection();
      }
    }
    request.offer(new Object(), 60, TimeUnit.SECONDS);
    synchronized (this) {
      if (pool.isConnectionAvailable() || pool.getCurrentPoolSize()<maxPoolSize) {
        request.take();
        return pool.getConnection();
      }
    }
    return null;
  }

}
