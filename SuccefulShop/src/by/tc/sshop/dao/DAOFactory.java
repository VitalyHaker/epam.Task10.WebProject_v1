package by.tc.sshop.dao;

import by.tc.sshop.dao.intface.*;
import by.tc.sshop.dao.impl.*;

public class DAOFactory {
    private static final DAOFactory INST = new DAOFactory();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return INST;
    }

    private UserDAO userDAO = new UserSqlDAO();
    private BikeDAO bikeDAO = new BikeSqlDAO();
    private CommentDAO commentDAO = new CommentSqlDAO();

    public UserDAO getUserDAO(){
        return userDAO;
    }

    public BikeDAO getBikeDAO() {
        return bikeDAO;
    }

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

}