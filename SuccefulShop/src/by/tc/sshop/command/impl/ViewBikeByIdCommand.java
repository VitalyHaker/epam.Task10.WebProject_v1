package by.tc.sshop.command.impl;

import by.tc.sshop.bean.entity.Bike;
import by.tc.sshop.command.Command;
import by.tc.sshop.service.BikeService;
import by.tc.sshop.service.ServiceFactory;
import by.tc.sshop.service.exception.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewBikeByIdCommand implements Command {
	
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final String CHARACTER_ENCODING = "UTF-8";
    
    private static final String JSP_PAGE_PATH = "jsp/bikes.jsp";
    private static final String ERROR_PAGE = "jsp/error.jsp";
    
    private static final String ERROR = "Error!";
    private static final String ERROR_NO_BIKES = "Sorry, currently there are no bikes this id.";
    
    private static final Logger LOGGER = LogManager.getLogger(ViewBikeByIdCommand.class.getName());

    private static final String ID = "id";
    private static final String REQUEST_ATTRIBUTE = "Bike";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String id = request.getParameter(ID);
        Bike Bike;
        BikeService BikeService = ServiceFactory.getInstance().getBikeService();
        try {
            Bike = BikeService.viewBikeById(id);
            /*for (Bike Bike : Bikes) {
                System.out.println(Bike.getTitle() + " - " + Bike.getYear());
            }*/
            request.setAttribute(REQUEST_ATTRIBUTE, Bike);
            request.getRequestDispatcher(JSP_PAGE_PATH).include(request, response);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            request.setAttribute(ERROR, ERROR_NO_BIKES);
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
    }
}

