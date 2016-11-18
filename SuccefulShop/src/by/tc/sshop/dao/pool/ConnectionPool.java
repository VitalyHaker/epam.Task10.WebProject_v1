package by.tc.sshop.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1/jackdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static BlockingQueue<Connection> connectFree;
    private static BlockingQueue<Connection> connectInUse;
    private final static ConnectionPool inst = new ConnectionPool();
    private static final int CONNECTION_COUNT = 5;

    private ConnectionPool() {
    }

    static {
        try {
            connectFree = new ArrayBlockingQueue<>(CONNECTION_COUNT);
            connectInUse = new ArrayBlockingQueue<>(CONNECTION_COUNT);
            Class.forName(DRIVER);
            Connection connection;
            for (int i = 0; i < CONNECTION_COUNT; i++) {
                connection = DriverManager.getConnection(URL, USER, PASS);
                connectFree.add(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public static ConnectionPool getInstance() {
        return inst;
    }

    public Connection takeConnection() throws ConnectionPoolException {
        Connection connection;
        try {
            if (connectFree == null) {
                System.out.println("bedaaa");
                throw new ConnectionPoolException("Pool doesn't exist");
            }
            connection = connectFree.take();
            connectInUse.put(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Couldn't take connection from pull", e);
        }
        return connection;
    }

    public void returnConnection(Connection connection) throws ConnectionPoolException {
        try {
            if (connection == null || connection.isClosed()) {
                throw new ConnectionPoolException("Closed connection return impossible.");
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("ReturnConnection has SQL exception.", e);
        }

        try {
            connectInUse.remove(connection);
            connectFree.put(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Connections to queues exception", e);
        }
    }


}