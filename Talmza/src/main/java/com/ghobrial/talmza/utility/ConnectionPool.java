package com.ghobrial.talmza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool implements IConnectionPool {

	private int initialSize, maxSize;

	private boolean waitIfBusy;

	private List<Connection> availableConnections, usedConnections;

	private String url, username, password;

	private static ConnectionPool instance;

	public static ConnectionPool getInstance(int initialSize, int maxSize, boolean waitIfBusy, String url,
			String username, String password) throws SQLException {

		if (instance == null) {

			synchronized (ConnectionPool.class) {

				if (instance == null) {
					instance = new ConnectionPool(initialSize, maxSize, waitIfBusy, url, username, password);
				}

			}
		}

		return instance;
	}

	private ConnectionPool(int initialSize, int maxSize, boolean waitIfBusy, String url, String username,
			String password) throws SQLException {
		super();
		this.initialSize = initialSize;
		this.maxSize = maxSize;
		this.waitIfBusy = waitIfBusy;
		this.url = url;
		this.username = username;
		this.password = password;
		availableConnections = new ArrayList<>(initialSize);
		usedConnections = new ArrayList<>();
		initializeResources();

	}

	private void initializeResources() throws SQLException {

		for (int i = 0; i < initialSize; i++) {
			availableConnections.add(createConnection());
		}

	}

	private Connection createConnection() throws SQLException {

		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public synchronized Connection getConnection() throws SQLException {

		Connection connection = null;

		if (!availableConnections.isEmpty()) {

			connection = availableConnections.remove(availableConnections.size() - 1);

		} else if (availableConnections.size() + usedConnections.size() < maxSize) {

			connection = createConnection();

		} else if (waitIfBusy) {
			try {

				wait();

				return getConnection();

			} catch (InterruptedException e) {

				e.printStackTrace();
				throw new RuntimeException("Error in wait thread");
			}
		} else {
			throw new RuntimeException("Maximum pool size reached, no available connections!");
		}

		usedConnections.add(connection);

		return connection;
	}

	@Override
	public synchronized void releaseConnection(Connection connection) {

		usedConnections.remove(connection);

		availableConnections.add(connection);

		notifyAll();

	}

	@Override
	public void shutdown() {

		availableConnections.forEach(c -> {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		availableConnections.clear();

		usedConnections.forEach(c -> {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		usedConnections.clear();

	}

	@Override
	public synchronized String toString() {

		String info = "available=" + availableConnections.size() + ", busy=" + usedConnections.size() + ", max="
				+ maxSize;
		return (info);
	}

}
