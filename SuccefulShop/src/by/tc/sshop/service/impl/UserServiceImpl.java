package by.tc.sshop.service.impl;

import by.tc.sshop.bean.entity.*;
import by.tc.sshop.dao.DAOFactory;
import by.tc.sshop.dao.exception.DAOException;
import by.tc.sshop.dao.intface.*;
import by.tc.sshop.service.UserService;
import by.tc.sshop.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    @Override
    public User viewUserByLogin(String login) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO dao = daoFactory.getUserDAO();
        //ReviewDAO reviewDAO = daoFactory.getReviewDAO();
        User user;
        //List<Review> reviewList;
        try {
            user = dao.viewUserByLogin(login);
            if (user != null) {
                //reviewList = reviewDAO.getReviewsForMovie(normId);
                //user.setReviews(reviewList);
            } else {
                throw new ServiceException("No user matching your query");
            }
        } catch (DAOException e) {
            throw new ServiceException("Error in source!", e);
        }
        return user;
    }
}
