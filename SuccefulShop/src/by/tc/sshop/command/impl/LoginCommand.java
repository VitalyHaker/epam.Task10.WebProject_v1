package by.tc.sshop.command.impl;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.command.Command;
import by.tc.sshop.util.ReqUtility;
import by.tc.sshop.service.LoginService;
import by.tc.sshop.service.ServiceFactory;
import by.tc.sshop.service.exception.ServiceAuthorizationException;
import by.tc.sshop.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoginCommand implements Command {
    private static final String JSP_PAGE_PATH = "jsp/authorization.jsp";
    private static final String START_PAGE = "index.jsp";

    private static final String ERROR = "Error!";
    private static final String MESSAGE_ENTER_LOGIN_PASS = "Please, enter your login and password.";
    private static final String MESSAGE_WRONG_LOGIN_PASS = "Sorry, your login or password is wrong!";

    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class.getName());
    
    private static final String USER = "user";
    private static final String LOGIN = "login";
    private static final String PASS = "pass";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter(LOGIN);
        String pass = request.getParameter(PASS);
        LoginService loginService = ServiceFactory.getInstance().getLoginService();
        HttpSession session = request.getSession(true);

        if (login != null && pass != null) {
            try {
                User user = loginService.toLogin(login, pass);
                session.setAttribute(USER, user);
                response.sendRedirect(START_PAGE);
            } catch (ServiceAuthorizationException e) {
                LOGGER.error(e.getMessage(), e);
                request.setAttribute(ERROR, MESSAGE_ENTER_LOGIN_PASS);
                request.getRequestDispatcher(JSP_PAGE_PATH).include(request, response);
            } catch (ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                request.setAttribute(ERROR, MESSAGE_WRONG_LOGIN_PASS);
                request.getRequestDispatcher(JSP_PAGE_PATH).include(request, response);
            }
        } else {
            ReqUtility.saveActualQueryToSession(request);
            request.getRequestDispatcher(JSP_PAGE_PATH).include(request, response);
        }
        
    }
}