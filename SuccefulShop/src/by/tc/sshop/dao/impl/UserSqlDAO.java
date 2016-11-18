package by.tc.sshop.dao.impl;

import by.tc.sshop.bean.entity.User;
import by.tc.sshop.dao.intface.UserDAO;
import by.tc.sshop.dao.exception.DAOException;
import by.tc.sshop.dao.pool.ConnectionPool;
import by.tc.sshop.dao.pool.ConnectionPoolException;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSqlDAO implements UserDAO {
    private final static String LOG_IN_STATEMENT = "SELECT * FROM users WHERE login=? and pass=?";
    private final static String REGISTER_STATEMENT = "INSERT INTO users (`login`, `pass`, `email`, `phone`, "
    		+ "`balance`, `coupon`, `fname`, `lname`, `birth`) VALUES(?,?,?,?,?,?,?,?,?)";
    private final static String VIEW_ALL_USERS = "SELECT * FROM users";
    private static final String VIEW_BY_LOGIN = "SELECT * FROM users WHERE login=?";

    private static final String IDUSER = "iduser";
    private static final String LOGIN = "login";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String BALANCE = "balance";
    private static final String COUPON = "coupon";
    private static final String FNAME = "fname";
    private static final String LNAME = "lname";
    private static final String BIRTH = "birth";
    private static final String ROLE = "role";
    private static final String BLOCKST = "blockSt";
    private static final String DELST = "delSt";

    public User authorize(String login, String pass) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();
            st = con.prepareStatement(LOG_IN_STATEMENT);
            st.setString(1, login);
            st.setString(2, pass);
            rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }

            User user = new User();
            user.setIdUser(rs.getInt(IDUSER));
            user.setLogin(rs.getString(LOGIN));
            user.setEmail(rs.getString(EMAIL));
            user.setPhone(rs.getString(PHONE));
            user.setBalance(rs.getBigDecimal(BALANCE));
            user.setCoupon(rs.getInt(COUPON));
            user.setPhone(rs.getString(FNAME));
            user.setPhone(rs.getString(LNAME));
            user.setBirth(rs.getDate(BIRTH));
            user.setRole(rs.getInt(ROLE));
            user.setBlockSt(rs.getInt(BLOCKST));
            user.setDelSt(rs.getInt(DELST));
            return user;

        } catch (SQLException e) {
            throw new DAOException("SQL login error", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Pool connection error", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing result set exception", e);
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
                throw new DAOException("Run connection exception", e);
            }

        }
    }

    public User register(String login, String pass, String email, String phone, BigDecimal balance,
    		int coupon, String fname, String lname, Date birth) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();

            st = con.prepareStatement(REGISTER_STATEMENT);
            st.setString(1, login);
            st.setString(2, pass);
            st.setString(3, email);
            st.setString(4, phone);
            st.setBigDecimal(5, balance);
            st.setInt(6, coupon);
            st.setString(7, fname);
            st.setString(8, lname);
            st.setDate(9, birth);
            int i = st.executeUpdate();
            if (i > 0) {
                return authorize(login, pass);
            }

        } catch (SQLException e) {
            throw new DAOException("Register sql error", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Pool connection error", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing result set exception", e);
                }
            }
            try {
                ConnectionPool.getInstance().returnConnection(con);
            } catch (ConnectionPoolException e) {
                throw new DAOException("Run connection exception", e);
            }
        }
        return null;
    }

    public List<User> viewAllUsers() throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();

            st = con.prepareStatement(VIEW_ALL_USERS);

            rs = st.executeQuery();

            List<User> users = new ArrayList<>();
            User user;
            while (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt(IDUSER));
                user.setLogin(rs.getString(LOGIN));
                user.setEmail(rs.getString(EMAIL));
                user.setPhone(rs.getString(PHONE));
                user.setBalance(rs.getBigDecimal(BALANCE));
                user.setCoupon(rs.getInt(COUPON));
                user.setPhone(rs.getString(FNAME));
                user.setPhone(rs.getString(LNAME));
                user.setBirth(rs.getDate(BIRTH));
                user.setRole(rs.getInt(ROLE));
                user.setBlockSt(rs.getInt(BLOCKST));
                user.setDelSt(rs.getInt(DELST));
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new DAOException("User sql error", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Movie pool connection error", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing result set exception", e);
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
                throw new DAOException("Run connection exception", e);
            }
        }
    }

    public User viewUserLogin(String login) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();

            st = con.prepareStatement(VIEW_BY_LOGIN);
            st.setString(1, login);
            rs = st.executeQuery();

            User user = null;
            if (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt(IDUSER));
                user.setLogin(rs.getString(LOGIN));
                user.setEmail(rs.getString(EMAIL));
                user.setPhone(rs.getString(PHONE));
                user.setBalance(rs.getBigDecimal(BALANCE));
                user.setCoupon(rs.getInt(COUPON));
                user.setPhone(rs.getString(FNAME));
                user.setPhone(rs.getString(LNAME));
                user.setBirth(rs.getDate(BIRTH));
                user.setRole(rs.getInt(ROLE));
                user.setBlockSt(rs.getInt(BLOCKST));
                user.setDelSt(rs.getInt(DELST));
            }
            return user;

        } catch (SQLException e) {
            throw new DAOException("User sql error", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("User pool connection error", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Closing result set exception", e);
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
                throw new DAOException("Run connection exception", e);
            }
        }
    }

	@Override
	public User register(String login, String pass, String email, String phone, int balance, int coupon, String fname,
			String lname, Date birth) throws DAOException {
		return null;
	}

	@Override
	public User viewUserByLogin(String login) throws DAOException {
		return null;
	}
}