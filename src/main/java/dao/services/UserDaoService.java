package dao.services;

import classes.User;
import dao.interfaces.Dao;
import dao.localstore.UsersDaoSql;

import java.sql.SQLException;
import java.util.List;

public class UserDaoService {

    private Dao<User> userDao = new UsersDaoSql();

    public List<User> getAllUsers() throws SQLException {
        return userDao.getAll();
    }

    public User getUser(int id) throws SQLException { return userDao.get(id); }

    public void addUser(String email, String name, String surname, String picUrl, int age, int password){
        userDao.save(new User(email, name, surname, picUrl, age, password));
    }

    public int getUserIdByMail(String mail){ return userDao.getId(mail); }
}
