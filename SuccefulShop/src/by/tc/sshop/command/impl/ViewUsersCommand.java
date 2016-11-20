package by.tc.sshop.command.impl;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.command.Command;
import by.tc.sshop.service.AdminService;
import by.tc.sshop.service.ServiceFactory;
import by.tc.sshop.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ViewUsersCommand implements Command {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final String CHARACTER_ENCODING = "UTF-8";
    
	private static final String USERS_PAGE = "jsp/users.jsp";
	private static final String ERROR_PAGE = "jsp/error.jsp";
	
    private static final String ERROR = "Error!";
    private static final String ERROR_NO_USERS = "No users.";
    
    private static final Logger LOGGER = LogManager.getLogger(ViewUsersCommand.class.getName());

    private static final String REQUEST_ATTRIBUTE = "all_users";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding(CHARACTER_ENCODING);
        List<User> users;
        AdminService adminService = ServiceFactory.getInstance().getAdminService();

        try {
            users = adminService.showAllUsers();
            request.setAttribute(REQUEST_ATTRIBUTE, users);
            request.getRequestDispatcher(USERS_PAGE).include(request, response);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            request.setAttribute(ERROR, ERROR_NO_USERS);
            request.getRequestDispatcher(ERROR_PAGE).include(request, response);
        }
    }
}