package by.tc.sshop.dao.intface;

import by.tc.sshop.bean.entity.Bike;
import by.tc.sshop.dao.exception.DAOException;

import java.math.BigDecimal;
import java.util.List;

public interface BikeDAO {
	Bike viewBikeById(int id) throws DAOException;
    List<Bike> fullList() throws DAOException;
    List<Bike> viewBikesBrand(String brand) throws DAOException;
    List<Bike> viewBikesWheeldiam(int wheeldiam) throws DAOException;

    void addBike(String brand, String model, int wheeldiam, String appointment, String sex, String manufacturer,
    		double framesize, String framematerial, String equipment, String image, String description,
    		int del_st, BigDecimal price, int discountPct) throws DAOException;
    void updateBike(int idBike, String brand, String model, int wheeldiam, String appointment, String sex, String manufacturer,
    		double framesize, String framematerial, String equipment, String image, String description,
    		int delSt, BigDecimal price, int discountPct) throws DAOException;

}