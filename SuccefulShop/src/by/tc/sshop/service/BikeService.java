package by.tc.sshop.service;

import by.tc.sshop.bean.entity.Bike;
import by.tc.sshop.service.exception.ServiceException;

import java.util.List;

public interface BikeService {
    //Bike viewBikeId(String id) throws ServiceException;
    List<Bike> viewFullList() throws ServiceException;
    List<Bike> viewBikesBrand(String brand) throws ServiceException;
    List<Bike> viewBikesWheeldiam(String wheeldiam) throws ServiceException;

    void addBike(String brand, String model, String wheeldiam, String appointment, String sex, String manufacturer,
    		String framesize, String framematerial, String equipment, String image, String description,
    		String delSt, String price, String discountPct) throws ServiceException;

    void updateBike(String idBike, String brand, String model, String wheeldiam, String appointment, String sex, String manufacturer,
    		String framesize, String framematerial, String equipment, String image, String description,
    		String delSt, String price, String discountPct) throws ServiceException;

    void addComment(String idUser, String idBike, String comment) throws ServiceException;

}

