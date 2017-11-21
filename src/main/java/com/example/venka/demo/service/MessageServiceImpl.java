package com.example.venka.demo.service;

import com.example.venka.demo.dao.MessageDAO;
import com.example.venka.demo.model.Message;
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
