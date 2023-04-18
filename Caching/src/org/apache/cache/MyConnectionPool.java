package org.apache.cache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;

public class MyConnectionPool {
  private Set<Connection> availableConnections;
  private Set<Connection>usedConnections;
  public MyConnectionPool(int poolSize, String url, String userId, String password)
      throws SQLException {
    for (int i = 0; i < poolSize; i++) {
      availableConnections.add(createConnection(url, userId, password));
    }
  }

  private Connection createConnection(String url, String userId, String password) throws
      SQLException {
    return DriverManager
        .getConnection(url, userId, password);
  }

  public synchronized Connection getConnection() {
    if(availableConnections.size()==0) {
      System.out.println("All connection are being used");
      return null;
    }
    Connection con = availableConnections.iterator().next();
    availableConnections.remove(con);
    usedConnections.add(con);
    return con;
  }

  public synchronized boolean releaseConnection(Connection con) {
    if (null != con) {
      usedConnections.remove(con);
      availableConnections.add(con);
      return true;
    }
    return false;
  }


}
