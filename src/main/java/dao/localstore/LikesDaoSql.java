package dao.localstore;

import classes.Like;
import dao.interfaces.Dao;
import jdbc.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikesDaoSql implements Dao<Like> {
    @Override
    public Like get(int id) throws SQLException {
        Connection connection = DbConnection.getConnection();
        final String SQL = "SELECT * FROM lieks WHERE id = " + id;
        PreparedStatement statement = connection.prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();

        int user_from = 0;
        int user_to = 0;
        boolean liked = false;

        while (resultSet.next()){
            user_from = resultSet.getInt("user_from");
            user_to = resultSet.getInt("user_to");
            liked = resultSet.getBoolean("liked");
        }

        return new Like(user_from, user_to, liked);
    }

    @Override
    public List<Like> getAll() throws SQLException {
        Connection conn = DbConnection.getConnection();
        final String SQLS = "SELECT * FROM likes";
        PreparedStatement stmt = conn.prepareStatement(SQLS);
        ResultSet rset = stmt.executeQuery();
        List<Like> allLikes = new ArrayList<>();

        while (rset.next()) {

            allLikes.add(new Like(
                    rset.getInt("user_from"),
                    rset.getInt("user_to"),
                    rset.getBoolean("liked")
            ));
        }

        return allLikes;
    }

    @Override
    public void save(Like like) {
        Connection conn = DbConnection.getConnection();
        final String SQL = "INSERT INTO postgres.likes (user_from, user_to, liked) VALUES (?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, like.getUserFrom());
            ps.setInt(2, like.getUserTo());
            ps.setBoolean(3, like.isLiked());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Like like) {

    }

    @Override
    public void delete(Like like) {

    }

    @Override
    public int getId(String s) { return 0; }
}
