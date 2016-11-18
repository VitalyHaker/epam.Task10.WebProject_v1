package by.tc.sshop.dao.intface;

import by.tc.sshop.bean.entity.Comment;
import by.tc.sshop.dao.exception.DAOException;

import java.util.List;

public interface CommentDAO {
    List<Comment> getCommentsForBike(int id) throws DAOException;

    void addComment(int idUser, int idBike, String comment) throws DAOException;
}

