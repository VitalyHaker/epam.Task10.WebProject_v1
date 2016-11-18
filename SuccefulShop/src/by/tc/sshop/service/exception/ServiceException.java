package by.tc.sshop.service.exception;

import by.tc.sshop.dao.exception.DAOException;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String s, DAOException e) {
        super(s, e);
    }
}