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

public class AddBikeCommand implements Command {

    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final String CHARACTER_ENCODING = "UTF-8";
    
    private static final String ADD_BIKE_PAGE = "jsp/bikes.jsp";
    private static final String START_PAGE = "index.jsp";
    private static final String ERROR_PAGE = "jsp/error.jsp";
    
    private static final String ERROR = "Error!";
    private static final String ERROR_REPORT = "Bike is not added.";
    private static final String ERROR_REPORT_INPUT = "Bike is not added, error input.";
    
    private static final Logger LOGGER = LogManager.getLogger(AddBikeCommand.class.getName());

    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String WHEELDIAM = "wheeldiam";
    private static final String APPOINTMENT = "appointment";
    private static final String SEX = "sex";
    private static final String MANUFACTURER = "manufacturer";
    private static final String FRAMESIZE = "framesize";
    private static final String FRAMEMATERIAL = "framematerial";
    private static final String EQUIPMENT = "equipment";
    private static final String IMAGE = "image";
    private static final String DESCRIPTION = "description";
    private static final String DEL_ST = "delSt";
    private static final String PRICE = "price";
    private static final String DISCOUNTPCT = "discountPct";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding(CHARACTER_ENCODING);
        String brand = request.getParameter(BRAND);
        String model = request.getParameter(MODEL);
        String wheeldiam = request.getParameter(WHEELDIAM);
        String appointment = request.getParameter(APPOINTMENT);
        String sex = request.getParameter(SEX);
        String manufacturer = request.getParameter(MANUFACTURER);
        String framesize = request.getParameter(FRAMESIZE);
        String framematerial = request.getParameter(FRAMEMATERIAL);
        String equipment = request.getParameter(EQUIPMENT);
        String image = request.getParameter(IMAGE);
        String description = request.getParameter(DESCRIPTION);
        String delSt = request.getParameter(DEL_ST);
        String price = request.getParameter(PRICE);
        String discountPct = request.getParameter(DISCOUNTPCT);
        System.out.println("Running the execute method of the class AdBike Command. Parameters obtained.");
        BikeService bikeService = ServiceFactory.getInstance().getBikeService();
       
        if (brand != null && model != null && wheeldiam != null && price !=null) {
            try {
                bikeService.addBike(brand, model, wheeldiam, appointment, sex, manufacturer, framesize, framematerial, 
                		equipment, image, description, delSt, price, discountPct);
                request.getRequestDispatcher(START_PAGE).include(request, response);
            }  catch (ServiceException e) {
                LOGGER.error(e.getMessage(), e);
                request.setAttribute(ERROR, ERROR_REPORT);
                request.getRequestDispatcher(ERROR_PAGE).include(request, response);
            }
        } else {
            ReqUtility.saveActualQueryToSession(request);
            request.setAttribute(ERROR, ERROR_REPORT_INPUT);
            request.getRequestDispatcher(ERROR_PAGE).include(request, response);
        }
        
        request.getRequestDispatcher(ADD_BIKE_PAGE).forward(request, response);
    }
}
