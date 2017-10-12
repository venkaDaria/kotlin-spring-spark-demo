package com.example.venka.javaspringsparkdemo.service;

import com.example.venka.javaspringsparkdemo.dao.MessageDAO;
import com.example.venka.javaspringsparkdemo.model.Message;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageDAO messageDAO;

    public MessageServiceImpl(@Autowired final MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public void insert(Message message) {
        messageDAO.insert(message);
    }

    @Override
    public void delete(ObjectId id) {
        messageDAO.delete(id);
    }

    @Override
    public List<Message> getAll() {
        return messageDAO.getAll();
    }

    @Override
    public Message getById(ObjectId id) {
        return messageDAO.getById(id);
    }
}
