package dao.services;

import classes.Message;
import dao.interfaces.Dao;
import dao.localstore.MessagesDaoSql;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class MessageDaoService {

    private Dao<Message> messageDao = new MessagesDaoSql();

    public List<Message> getMessages(int userOne, int userTwo) throws SQLException {
        return messageDao.getAll().stream()
                .filter(m -> m.getFrom() == userOne || m.getFrom() == userTwo)
                .filter(m -> m.getTo() == userOne || m.getTo() == userTwo)
                .collect(Collectors.toList());
    }

    public void saveMessage(int from, int to, String text, long time) {
        messageDao.save(new Message(from, to, text, time));
    }
}
