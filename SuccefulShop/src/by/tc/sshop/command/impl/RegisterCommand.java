package by.tc.sshop.command.impl;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.command.Command;
import by.tc.sshop.util.ReqUtility;
import by.tc.sshop.service.RegisterService;
import by.tc.sshop.service.ServiceFactory;
import by.tc.sshop.service.exception.ServiceAuthorizationException;
import by.tc.sshop.service.exception.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand implements Command {
    private static final String REGISTRATION_PAGE = "jsp/registration.jsp";
    private static final String START_PAGE = "index.jsp";

    private static final String ERROR = "Error!";
    private static final String ERROR_FIELDS = "Please, complete all fields in the registration form.";
    private static final String ERROR_INVALID_LOGIN_PASSWORD = "Attention! Login or password are invalid.";
    
    private static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class.getName());
    
    private static final String USER = "user";
    private static final String LOGIN = "login";
    private static final String PASS = "pass";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String BALANCE = "balance";
    private static final String COUPON = "coupon";
    private static final String FNAME = "fname";
    private static final String LNAME = "lname";
    private static final String BIRTH = "birth";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter(LOGIN);
        String pass = request.getParameter(PASS);
        String email = request.getParameter(EMAIL);
        String phone= request.getParameter(PHONE);
        String balance = request.getParameter(BALANCE);
        String coupon = request.getParameter(COUPON);
        String fname = request.getParameter(FNAME);
        String lname = request.getParameter(LNAME);
        String birth = request.getParameter(BIRTH);
        RegisterService registerService = ServiceFactory.getInstance().getRegisterService();

        if (login != null && pass != null && email != null && phone != null) {
            try {
                User user = registerService.register(login, pass, email, phone, balance, coupon, fname, lname, birth);

                request.setAttribute(USER, user);

                request.getRequestDispatcher(START_PAGE).include(request, response);
                System.out.println("Registration is finished.");
            } catch (ServiceAuthorizationException e) {
                LOGGER.error(e.getMessage(), e);
                request.setAttribute(ERROR, ERROR_FIELDS);
                request.getRequestDispatcher(REGISTRATION_PAGE).include(request, response);
            } catch (ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                request.setAttribute(ERROR, ERROR_INVALID_LOGIN_PASSWORD);
                request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
            }
        } else {
            ReqUtility.saveActualQueryToSession(request);
        }
        
        request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
    }
}
