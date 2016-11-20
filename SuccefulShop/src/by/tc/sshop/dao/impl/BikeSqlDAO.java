package by.tc.sshop.dao.impl;

import by.tc.sshop.bean.entity.Bike;
import by.tc.sshop.dao.intface.BikeDAO;
import by.tc.sshop.dao.exception.DAOException;
import by.tc.sshop.dao.pool.ConnectionPool;
import by.tc.sshop.dao.pool.ConnectionPoolException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeSqlDAO implements BikeDAO {
    private final static String VIEW_ALL = "SELECT * FROM `sshop`.`bikes`";
    private final static String VIEW_BY_ID = "SELECT * FROM `sshop`.`bikes` WHERE `id_bike`=?";
    private final static String VIEW_BY_BRAND = "SELECT * FROM `sshop`.`bikes` WHERE `brand`=?";
    private static final String VIEW_BY_WHEELDIAM = "SELECT * FROM `sshop`.`bikes` WHERE `wheeldiam`=?";
    private final static String ADD_BIKE = "INSERT INTO `sshop`.`bikes` (`brand`, `model`, `wheeldiam`, `appointment`, "
    		+ "`sex`, `manufacturer`, `framesize`,`framematerial`, `equipment`, `image`, `description`, `del_st`, "
    		+ "`price`, `discountPct`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_BY_ID = "UPDATE `sshop`.`bikes` SET `brand`=?, `model`=?, `wheeldiam`=?, "
    		+ "`appointment`=?, `sex`=?, `manufacturer`=?, `framesize`=?, `framematerial`=?, `equipment`=?, `image`=?, "
    		+ ", `description`=?, `del_st`=?, `price`=?, `discountPct`=? WHERE `idBike` = ?";

    private static final String IDBIKE = "idBike";
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String WHEELDIAM = "wheeldiam";
    private static final String APPOINTMENT = "apppointment";
    private static final String SEX = "sex";
    private static final String MANUFACTURER = "manufacturer";
    private static final String FRAMESIZE = "framesize";
    private static final String FRAMEMATERIAL = "framematerial";
    private static final String EQUIPMENT = "equipment";
    private static final String IMAGE = "image";
    private static final String DESCRIPTION = "description";
    private static final String DELST = "delSt";
    private static final String PRICE = "price";
    private static final String DISCOUNTPCT = "dicountPct";
    
    public List<Bike> fullList() throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();
            st = con.prepareStatement(VIEW_ALL);
            rs = st.executeQuery();
            List<Bike> bikes = new ArrayList<Bike>();
            Bike Bike;
            while (rs.next()) {
                Bike = new Bike();
                Bike.setIdBike(rs.getInt(IDBIKE));
                Bike.setBrand(rs.getString(BRAND));
                Bike.setModel(rs.getString(MODEL));
                Bike.setWheeldiam(rs.getInt(WHEELDIAM));
                Bike.setAppointment(rs.getString(APPOINTMENT));
                Bike.setSex(rs.getString(SEX));
                Bike.setManufacturer(rs.getString(MANUFACTURER));
                Bike.setFramesize(rs.getDouble(FRAMESIZE));
                Bike.setFramematerial(rs.getString(FRAMEMATERIAL));
                Bike.setEquipment(rs.getString(EQUIPMENT));
                Bike.setImage(rs.getString(IMAGE));
                Bike.setDescription(rs.getString(DESCRIPTION));
                Bike.setDelSt(rs.getInt(DELST));
                Bike.setPrice(rs.getBigDecimal(PRICE));
                Bike.setDiscountPct(rs.getInt(DISCOUNTPCT));
                bikes.add(Bike);
            }
            return bikes;

        } catch (SQLException e) {
            throw new DAOException("SQL error in Bike", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Pool connection error in Bike", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Exception while closing result set", e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing statement exception", e);
                }
            }
            try {
                ConnectionPool.getInstance().returnConnection(con);
            } catch (ConnectionPoolException e) {
                throw new DAOException("Returning connection exception", e);
            }
        }
    }

    @Override
    public List<Bike> viewBikesBrand(String brand) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();

            st = con.prepareStatement(VIEW_BY_BRAND);
            st.setString(1, brand);
            rs = st.executeQuery();

            List<Bike> Bikes = new ArrayList<>();
            Bike Bike;
            while (rs.next()) {
                Bike = new Bike();
                Bike.setIdBike(rs.getInt(IDBIKE));
                Bike.setBrand(rs.getString(BRAND));
                Bike.setModel(rs.getString(MODEL));
                Bike.setWheeldiam(rs.getInt(WHEELDIAM));
                Bike.setAppointment(rs.getString(APPOINTMENT));
                Bike.setSex(rs.getString(SEX));
                Bike.setManufacturer(rs.getString(MANUFACTURER));
                Bike.setFramesize(rs.getDouble(FRAMESIZE));
                Bike.setFramematerial(rs.getString(FRAMEMATERIAL));
                Bike.setEquipment(rs.getString(EQUIPMENT));
                Bike.setImage(rs.getString(IMAGE));
                Bike.setDescription(rs.getString(DESCRIPTION));
                Bike.setDelSt(rs.getInt(DELST));
                Bike.setPrice(rs.getBigDecimal(PRICE));
                Bike.setDiscountPct(rs.getInt(DISCOUNTPCT));
                Bikes.add(Bike);
            }
            return Bikes;

        } catch (SQLException e) {
            throw new DAOException("SQL error in Bike", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Pool connection error in Bike", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Exception while closing result set", e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing statement exception", e);
                }
            }
            try {
                ConnectionPool.getInstance().returnConnection(con);
            } catch (ConnectionPoolException e) {
                throw new DAOException("Returning connection exception", e);
            }
        }
    }

    @Override
    public List<Bike> viewBikesWheeldiam(int wheeldiam) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();

            st = con.prepareStatement(VIEW_BY_WHEELDIAM);
            st.setInt(1, wheeldiam);
            rs = st.executeQuery();

            List<Bike> Bikes = new ArrayList<>();
            Bike Bike;
            while (rs.next()) {
                Bike = new Bike();
                Bike.setIdBike(rs.getInt(IDBIKE));
                Bike.setBrand(rs.getString(BRAND));
                Bike.setModel(rs.getString(MODEL));
                Bike.setWheeldiam(rs.getInt(WHEELDIAM));
                Bike.setAppointment(rs.getString(APPOINTMENT));
                Bike.setSex(rs.getString(SEX));
                Bike.setManufacturer(rs.getString(MANUFACTURER));
                Bike.setFramesize(rs.getDouble(FRAMESIZE));
                Bike.setFramematerial(rs.getString(FRAMEMATERIAL));
                Bike.setEquipment(rs.getString(EQUIPMENT));
                Bike.setImage(rs.getString(IMAGE));
                Bike.setDescription(rs.getString(DESCRIPTION));
                Bike.setDelSt(rs.getInt(DELST));
                Bike.setPrice(rs.getBigDecimal(PRICE));
                Bike.setDiscountPct(rs.getInt(DISCOUNTPCT));
                Bikes.add(Bike);
            }
            return Bikes;

        } catch (SQLException e) {
            throw new DAOException("SQL error in Bike", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Pool connection error in Bike", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Exception while closing result set", e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing statement exception", e);
                }
            }
            try {
                ConnectionPool.getInstance().returnConnection(con);
            } catch (ConnectionPoolException e) {
                throw new DAOException("Returning connection exception", e);
            }
        }
    }

    @Override
    public Bike viewBikeById(int idBike) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();

            st = con.prepareStatement(VIEW_BY_ID);
            st.setInt(1, idBike);
            rs = st.executeQuery();

            Bike Bike = null;
            if (rs.next()) {
                Bike = new Bike();
                Bike.setIdBike(rs.getInt(IDBIKE));
                Bike.setBrand(rs.getString(BRAND));
                Bike.setWheeldiam(rs.getInt(WHEELDIAM));
                Bike.setAppointment(rs.getString(APPOINTMENT));
                Bike.setSex(rs.getString(SEX));
                Bike.setManufacturer(rs.getString(MANUFACTURER));
                Bike.setFramesize(rs.getDouble(FRAMESIZE));
                Bike.setFramematerial(rs.getString(FRAMEMATERIAL));
                Bike.setEquipment(rs.getString(EQUIPMENT));
                Bike.setImage(rs.getString(IMAGE));
                Bike.setDescription(rs.getString(DESCRIPTION));
                Bike.setDelSt(rs.getInt(DELST));
                Bike.setPrice(rs.getBigDecimal(PRICE));
                Bike.setDiscountPct(rs.getInt(DISCOUNTPCT));
            }
            return Bike;

        } catch (SQLException e) {
            throw new DAOException("SQL error in Bike", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Pool connection error in Bike", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Exception while closing result set", e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing statement exception", e);
                }
            }
            try {
                ConnectionPool.getInstance().returnConnection(con);
            } catch (ConnectionPoolException e) {
                throw new DAOException("Returning connection exception", e);
            }
        }
    }

    @Override
    public void addBike(String brand, String model, int wheeldiam, String appointment, String sex, String manufacturer,
    		double framesize, String framematerial, String equipment, String image, String description,
    		int delSt, BigDecimal price, int discountPct) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();
            st = con.prepareStatement(ADD_BIKE);
            st.setString(1, brand);
            st.setString(2, model);
            st.setInt(3, wheeldiam);
            st.setString(4, appointment);
            st.setString(5, sex);
            st.setString(6, manufacturer);
            st.setDouble(7, framesize);
            st.setString(8, framematerial);
            st.setString(9, equipment);
            st.setString(10, image);
            st.setString(11, description);
            st.setInt(12, delSt);
            st.setBigDecimal(13, price);
            st.setInt(14, discountPct);
            
            int update = st.executeUpdate();
            if (update > 0) {
                System.out.println("Bike dobavlen vse ok" + brand + model);
                return;
            }
            throw new DAOException("Wrong Bike data");
        } catch (SQLException e) {
            throw new DAOException("SQL error in Bike", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Pool connection error in Bike", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing statement exception", e);
                }
            }
            try {
                ConnectionPool.getInstance().returnConnection(con);
            } catch (ConnectionPoolException e) {
                throw new DAOException("Returning connection exception", e);
            }
        }
    }

    @Override
    public void updateBike(int idBike, String brand, String model, int wheeldiam, String appointment, String sex, String manufacturer,
    		double framesize, String framematerial, String equipment, String image, String description,
    		int delSt, BigDecimal price, int discountPct) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();
            st = con.prepareStatement(UPDATE_BY_ID);
            st.setString(1, brand);
            st.setString(2, model);
            st.setInt(3, wheeldiam);
            st.setString(4, appointment);
            st.setString(5, sex);
            st.setString(6, manufacturer);
            st.setDouble(7, framesize);
            st.setString(8, framematerial);
            st.setString(9, equipment);
            st.setString(10, image);
            st.setString(11, description);
            st.setInt(12, delSt);
            st.setBigDecimal(13, price);
            st.setInt(14, discountPct);
            st.setInt(15, idBike);
            int update = st.executeUpdate();
            if (update > 0) {
                //System.out.println("Bike updated" + brand + model);
                return;
            }
            throw new DAOException("Wrong Bike data");
        } catch (SQLException e) {
            throw new DAOException("SQL error in Bike", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Pool connection error in Bike", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing statement exception", e);
                }
            }
            try {
                ConnectionPool.getInstance().returnConnection(con);
            } catch (ConnectionPoolException e) {
                throw new DAOException("Returning connection exception", e);
            }
        }
    }

}
