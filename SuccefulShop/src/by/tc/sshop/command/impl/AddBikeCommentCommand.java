package by.tc.sshop.command.impl;

import by.tc.sshop.command.Command;
import by.tc.sshop.util.ReqUtility;
import by.tc.sshop.service.BikeService;
import by.tc.sshop.service.ServiceFactory;
import by.tc.sshop.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AddBikeCommentCommand implements Command {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final String CHARACTER_ENCODING = "UTF-8";
    
    private static final String START_PAGE = "index.jsp";
    private static final String ERROR_PAGE = "jsp/error.jsp";

    private static final String ERROR = "Error!";
    private static final String MESSAGE_OF_ERROR = "Attention! Comment was not added.";
    
    private static final Logger LOGGER = LogManager.getLogger(AddBikeCommentCommand.class.getName());

    private static final String IDBike = "idBike";
    private static final String IDUser = "idUser";
    private static final String COMMENT = "comment";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding(CHARACTER_ENCODING);

        String idBike = request.getParameter(IDBike);
        String idUser = request.getParameter(IDUser);
        String comment = request.getParameter(COMMENT);
        BikeService BikeService = ServiceFactory.getInstance().getBikeService();

        if (idBike != null && idUser != null && comment != null) {
            try {
                BikeService.addComment(idBike, idUser, comment);
                request.getRequestDispatcher(START_PAGE).include(request, response);
            } catch (ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                request.setAttribute(ERROR, MESSAGE_OF_ERROR);
                request.getRequestDispatcher(ERROR_PAGE).include(request, response);
                response.sendRedirect(START_PAGE);
            }
        } else {
            ReqUtility.saveActualQueryToSession(request);
        }
    }
}
