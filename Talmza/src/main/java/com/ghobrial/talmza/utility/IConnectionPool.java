package com.ghobrial.talmza.utility;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionPool {

	Connection getConnection() throws SQLException;

	void releaseConnection(Connection connection);

	void shutdown();

}
