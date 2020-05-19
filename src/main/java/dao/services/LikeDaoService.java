package dao.services;

import classes.Like;
import dao.interfaces.Dao;
import dao.localstore.LikesDaoSql;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LikeDaoService {

    private Dao<Like> likeDao = new LikesDaoSql();

    public List<Like> getAll() throws SQLException {
        return likeDao.getAll();
    }

    public Set<Like> getAllMarked(int user_from) throws SQLException {
        return likeDao.getAll().stream()
                .filter(u -> u.getUserFrom() == user_from)
                .collect(Collectors.toSet());
    }

    public Set<Like> getAllLikedUsers(int userFrom) throws SQLException {
        return likeDao.getAll().stream()
                    .filter(u -> u.getUserFrom() == userFrom)
                    .filter(Like::isLiked)
                    .collect(Collectors.toSet());
    }

    public void saveLike(int from, int to, boolean liked) {
        likeDao.save(new Like(from, to, liked));
    }
}
