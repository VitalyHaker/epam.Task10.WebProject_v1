package by.tc.sshop.service.impl;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.dao.DAOFactory;
import by.tc.sshop.dao.exception.DAOException;
import by.tc.sshop.dao.intface.UserDAO;
import by.tc.sshop.service.LoginService;
import by.tc.sshop.service.exception.ServiceAuthorizationException;
import by.tc.sshop.service.exception.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LogManager.getRootLogger();

    @Override
    public User toLogin(String login, String pass) throws ServiceException{
        logger.debug("Start authorization");
        if(!Validation.validate(login, pass)){
            throw new ServiceAuthorizationException("Parameters are incorrect.");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO dao = daoFactory.getUserDAO();

        User user;
        try {
            user = dao.authorize(login, pass);

            if(user == null){
                throw new ServiceAuthorizationException("Login or password are incorrect");
            }

        } catch (DAOException e) {
            throw new ServiceException("Source error.", e);
        }

        return user;
    }

    private static class Validation{
        static boolean validate(String login, String pass){
            if(login == null || login.isEmpty()){
                return false;
            }
            if(pass == null || pass.isEmpty()){
                return false;
            }
            return true;
            //experimental, will be more difficult validation
        }
    }
}