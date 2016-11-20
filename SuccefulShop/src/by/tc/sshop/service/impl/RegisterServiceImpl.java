package by.tc.sshop.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.dao.DAOFactory;
import by.tc.sshop.dao.intface.UserDAO;
import by.tc.sshop.dao.exception.DAOException;
import by.tc.sshop.service.RegisterService;
import by.tc.sshop.service.exception.ServiceAuthorizationException;
import by.tc.sshop.service.exception.ServiceException;

public class RegisterServiceImpl implements RegisterService {

    @Override
    public User register(String login, String pass, String email, String phone, String balance,
    		String coupon, String fname, String lname, String birth) throws ServiceException {
            if(!Validation.validate(login, pass, email, phone)){
                throw new ServiceAuthorizationException("Check input parameters");
            }

            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO dao = daoFactory.getUserDAO();
            BigDecimal balanceParse;
            int couponParse;
            Date birthParse;
            User user;
            
            try {
            	balanceParse = new BigDecimal(balance);
            	couponParse = Integer.parseInt(coupon);
            	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       			java.util.Date parsed;
				parsed = format.parse(birth);
       			birthParse = new Date(parsed.getTime());
            } catch (NumberFormatException e) {
                throw new ServiceException("Data input adding bike is incorrect");
            } catch (ParseException e) {
				throw new ServiceException("Data input adding bike is incorrect in field 'birth'");
			}
            
            try {
                user = dao.register(login, pass, email, phone, balanceParse, couponParse, fname, lname, birthParse);

                if(user == null){
                    throw new ServiceAuthorizationException("Wrong login or pass!");
                }

            } catch (DAOException e) {
                throw new ServiceException("Error in source!", e);
            }

            return user;
        }

        private static class Validation{
            static boolean validate(String login, String pass, String email, String phone){

                if(login == null || login.isEmpty() || !login.matches("^[a-zA-Z0-9._-]{3,}$")){
                    return false;
                }

                if(pass == null || pass.isEmpty() || !pass.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{8,}")){
                    return false;
                }

                if(email == null || email.isEmpty() || !email.matches("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}")){
                    return false;
                }
                
                if(phone == null || phone.isEmpty() || !pass.matches("^\\+(?:[0-9] ?){6,14}[0-9]$}")){
                    return false;
                }

                return true;
            }
        }
}
