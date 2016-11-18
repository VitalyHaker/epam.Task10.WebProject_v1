package by.tc.sshop.service;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.service.exception.ServiceException;

import java.util.List;

public interface AdminService {
    void banUser(String login) throws ServiceException;
    void unbanUser(String login) throws ServiceException;

    List<User> showAllUsers() throws ServiceException;
}
