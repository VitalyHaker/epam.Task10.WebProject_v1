package by.tc.sshop.command.impl;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.command.Command;
import by.tc.sshop.service.ServiceFactory;
import by.tc.sshop.service.UserService;
import by.tc.sshop.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ViewUserCommand implements Command {

    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final String CHARACTER_ENCODING = "UTF-8";
    
	private static final String USER_PAGE = "jsp/user.jsp";
    private static final String ERROR_PAGE = "jsp/error.jsp";
    
    private static final Logger LOGGER = LogManager.getLogger(ViewUserCommand.class.getName());

    private static final String NICKNAME = "nickname";

    private static final String REQUEST_ATTRIBUTE = "user";
    private static final String ERROR = "Error!";
    private static final String ERROR_LOGIN = "sorry, a user with the same name does not exist.";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String login = request.getParameter(NICKNAME);
        User user;
        UserService userService = ServiceFactory.getInstance().getUserService();
        try {
            user = userService.viewUserByLogin(login);
            request.setAttribute(REQUEST_ATTRIBUTE, user);
            request.getRequestDispatcher(USER_PAGE).include(request, response);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            request.setAttribute(ERROR, ERROR_LOGIN);
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
    }
}
