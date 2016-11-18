package by.tc.sshop.dao.intface;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.dao.exception.DAOException;

import java.sql.Date;
import java.util.List;

public interface UserDAO {
    User authorize(String login, String pass) throws DAOException;
    User register(String login, String pass, String email, String phone, int balance,
    		int coupon, String fname, String lname, Date birth) throws DAOException;
    List<User> viewAllUsers() throws DAOException;
    User viewUserByLogin(String login) throws DAOException;
}