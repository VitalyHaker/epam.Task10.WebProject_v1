package by.tc.sshop.service;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.service.exception.ServiceException;

public interface LoginService {
    User toLogin(String login, String pass) throws ServiceException;
}
