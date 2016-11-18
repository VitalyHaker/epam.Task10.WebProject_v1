package by.tc.sshop.dao.impl;

import by.tc.sshop.bean.entity.Comment;
import by.tc.sshop.dao.exception.DAOException;
import by.tc.sshop.dao.intface.CommentDAO;
import by.tc.sshop.dao.pool.ConnectionPool;
import by.tc.sshop.dao.pool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentSqlDAO implements CommentDAO {
    private final static String VIEW_COMMENTS_BY_BIKE = "SELECT c.id_bike, u.id_user, u.login, c.comment  FROM users as u, "
    		+ "comments as c WHERE (u.idUser=c.idUser AND c.idBike=?)";
    private static final String ADD_COMMENT_TO_BIKE = "INSERT INTO comments (id_user, id_bike, comment) VALUES (?, ?, ?)";
    private static final String IDUSER = "id_user";
    private static final String IDBIKE = "id_bike";
    private static final String COMMENT = "comment";

    @Override
    public List<Comment> getCommentsForBike(int idBike) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();
            st = con.prepareStatement(VIEW_COMMENTS_BY_BIKE);
            st.setInt(1, idBike);
            rs = st.executeQuery();
            List<Comment> CommentList = new ArrayList<>();
            Comment Comment = null;
            while (rs.next()) {
                Comment = new Comment();
                Comment.setIdUser(rs.getInt(IDUSER));
                Comment.setIdBike(rs.getInt(IDBIKE));
                Comment.setComment(rs.getString(COMMENT));
                CommentList.add(Comment);
            }
            return CommentList;

        } catch (SQLException e) {
            throw new DAOException("Country sql error", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Country pool connection error", e);
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
    public void addComment(int idUser, int idBike, String comment) throws DAOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = ConnectionPool.getInstance().takeConnection();
            st = con.prepareStatement(ADD_COMMENT_TO_BIKE);
            st.setInt(1, idUser);
            st.setInt(2, idBike);
            st.setString(3, comment);
            int update = st.executeUpdate();
            if (update > 0) {
                System.out.println("Comment dobavlen vse ok"+idUser+" "+comment);
                return;
            }
            throw new DAOException("Bike data is incorrect");
        } catch (SQLException e) {
            throw new DAOException("Sql error in Bike", e);
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
