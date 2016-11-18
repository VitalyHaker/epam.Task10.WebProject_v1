package by.tc.sshop.service.impl;

import by.tc.sshop.bean.entity.Bike;
import by.tc.sshop.dao.DAOFactory;
import by.tc.sshop.dao.intface.BikeDAO;
import by.tc.sshop.dao.exception.DAOException;
import by.tc.sshop.dao.intface.CommentDAO;
import by.tc.sshop.service.BikeService;
import by.tc.sshop.service.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public class BikeServiceImpl implements BikeService {
    @Override
    public List<Bike> viewFullList() throws ServiceException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        BikeDAO dao = daoFactory.getBikeDAO();
        List<Bike> bikes;
        try {
            bikes = dao.fullList();
            if (bikes == null || bikes.size() == 0) {
                throw new ServiceException("Our shop has no bikes according your parameters.");
            }
        } catch (DAOException e) {
            throw new ServiceException("Source error.", e);
        }
        return bikes;
    }

    @Override
    public List<Bike> viewBikesBrand(String brand) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BikeDAO dao = daoFactory.getBikeDAO();
        List<Bike> bikes;
        try {
            bikes = dao.viewBikesBrand(brand);
            if (bikes == null || bikes.size() == 0) {
                throw new ServiceException("Our shop has no bikes according your parameters.");
            }
        } catch (DAOException e) {
            throw new ServiceException("Source error.", e);
        }
        return bikes;
    }

    @Override
    public List<Bike> viewBikesWheeldiam(String wheeldiam) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BikeDAO dao = daoFactory.getBikeDAO();
        List<Bike> bikes;
        int wheeldiamParse;
        try {
        	wheeldiamParse = Integer.parseInt(wheeldiam);
            bikes = dao.viewBikesWheeldiam(wheeldiamParse);
            if (bikes == null || bikes.size() == 0) {
                throw new ServiceException("Our shop has no bikes according your parameters.");
            }
        } catch (DAOException e) {
            throw new ServiceException("Source error.", e);
        }
        return bikes;
    }

    /*@Override
    public Bike showBikeByID(String idBike) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BikeDAO dao = daoFactory.getBikeDAO();
        CommentDAO CommentDAO = daoFactory.getCommentDAO();
        Bike bike;
        List<Comment> CommentList;
        int idBikeParse;
        try {
        	idBikeParse = Integer.parseInt(idBike);
        } catch (NumberFormatException e) {
            throw new ServiceException("No bikes by ID");
        }
        try {
            bike = dao.viewBikeById(idBikeParse);
            if (bike != null) {
                commentList = commentDAO.getCommentsForBike(idBikeParse);
                Bike.setComments(CommentList);
            } else {
                throw new ServiceException("Our shop has no bikes according your parameters.");
            }
        } catch (DAOException e) {
            throw new ServiceException("Source error!", e);
        }
        return bike;
    }
*/
    @Override
    public void addBike(String brand, String model, String wheeldiam, String appointment, String sex, String manufacturer,
    		String framesize, String framematerial, String equipment, String image, String description,
    		String delSt, String price, String discountPct) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BikeDAO dao = daoFactory.getBikeDAO();
        int wheeldiamParse;
        double framesizeParse;
        int delStParse;
        BigDecimal priceParse;
        int discountPctParse;
                
        try {
        	wheeldiamParse = Integer.parseInt(wheeldiam);
        	framesizeParse = Double.parseDouble(framesize);
        	delStParse = Integer.parseInt(delSt);
        	priceParse = new BigDecimal(price); 
        	discountPctParse = Integer.parseInt(discountPct);;
        } catch (NumberFormatException e) {
            throw new ServiceException("Data input adding bike is incorrect");
        }

        try {

            dao.addBike(brand, model, wheeldiamParse, appointment, sex, manufacturer, framesizeParse, framematerial, equipment, 
            		image, description, delStParse, priceParse, discountPctParse);

        } catch (DAOException e) {
            throw new ServiceException("Source error.", e);
        }
    }

    @Override
    public void updateBike(String idBike, String brand, String model, String wheeldiam, String appointment, String sex, String manufacturer,
    		String framesize, String framematerial, String equipment, String image, String description,
    		String delSt, String price, String discountPct) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        BikeDAO dao = daoFactory.getBikeDAO();
        int idParse;
        int wheeldiamParse;
        double framesizeParse;
        int delStParse;
        BigDecimal priceParse;
        int discountPctParse;
                
        try {
        	idParse = Integer.parseInt(idBike);
        	wheeldiamParse = Integer.parseInt(wheeldiam);
        	framesizeParse = Double.parseDouble(framesize);
        	delStParse = Integer.parseInt(delSt);
        	priceParse = new BigDecimal(price); 
        	discountPctParse = Integer.parseInt(discountPct);;
        } catch (NumberFormatException e) {
            throw new ServiceException("Data input adding bike is incorrect");
        }

        try {
            dao.updateBike(idParse, brand, model, wheeldiamParse, appointment, sex, manufacturer, framesizeParse, framematerial, equipment, 
            		image, description, delStParse, priceParse, discountPctParse);
        } catch (DAOException e) {
            throw new ServiceException("Source error.", e);
        }
    }

    @Override
    public void addComment(String idUser, String idBike, String comment) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        CommentDAO dao = daoFactory.getCommentDAO();
        int intIdUserParse;
        int intIdBikeParse;
        try {
            intIdUserParse = Integer.parseInt(idUser);
            intIdBikeParse = Integer.parseInt(idBike);
        } catch (NumberFormatException e) {
            throw new ServiceException("Data input adding bike is incorrect");
        }
        try {
            dao.addComment(intIdUserParse, intIdBikeParse, comment);
        } catch (DAOException e) {
            throw new ServiceException("Source error.", e);
        }
    }


}