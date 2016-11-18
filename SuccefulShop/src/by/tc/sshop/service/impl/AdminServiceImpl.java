package by.tc.sshop.service.impl;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.dao.DAOFactory;
import by.tc.sshop.dao.exception.DAOException;
import by.tc.sshop.dao.intface.UserDAO;
import by.tc.sshop.service.AdminService;
import by.tc.sshop.service.exception.ServiceException;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Override
    public void banUser(String login) throws ServiceException {

    }

    @Override
    public void unbanUser(String login) throws ServiceException {

    }

    @Override
    public List<User> showAllUsers() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO dao = daoFactory.getUserDAO();
        List<User> users;
        try {
            users = dao.viewAllUsers();
            if (users == null || users.size() == 0) {
                throw new ServiceException("No such users.");
            }
        } catch (DAOException e) {
            throw new ServiceException("Source error.", e);
        }
        return users;
    }
}