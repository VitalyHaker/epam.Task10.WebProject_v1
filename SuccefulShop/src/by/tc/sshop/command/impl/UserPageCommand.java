package by.tc.sshop.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.command.Command;

public class UserPageCommand implements Command {
    private static final String USER_PAGE = "jsp/userpage.jsp";
    private static final String LOGIN_PAGE = "jsp/authorization.jsp";

    private static final String USER = "user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Object obj = request.getSession(true).getAttribute(USER);
        if (obj != null && obj instanceof User) {
            request.getRequestDispatcher(USER_PAGE).include(request, response);
        } else {
            response.sendRedirect(LOGIN_PAGE);
        }
    }
}
