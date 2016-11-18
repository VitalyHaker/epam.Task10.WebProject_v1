package by.tc.sshop.service;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.service.exception.ServiceException;

public interface UserService {
    User showUserByLogin(String login) throws ServiceException;
}