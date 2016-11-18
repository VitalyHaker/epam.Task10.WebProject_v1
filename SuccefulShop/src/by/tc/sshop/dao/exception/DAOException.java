package by.tc.sshop.dao.exception;

import by.tc.sshop.dao.pool.ConnectionPoolException;

import java.sql.SQLException;

public class DAOException extends Exception {
	
    private static final long serialVersionUID = 1L;

    public DAOException(String s, SQLException e) {
        super(s, e);
    }

    public DAOException(String s, ConnectionPoolException e) {
        super(s, e);
    }

    public DAOException(String s) {
        super(s);
    }
}
