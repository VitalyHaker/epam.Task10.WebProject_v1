package by.tc.sshop.service;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.service.exception.ServiceException;

public interface RegisterService {
    User register(String login, String pass, String email, String phone, String balance,
    		String coupon, String fname, String lname, String birth) throws ServiceException;
}
