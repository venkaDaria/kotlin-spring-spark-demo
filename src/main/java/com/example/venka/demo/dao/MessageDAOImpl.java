package com.example.venka.demo.dao;

import com.example.venka.demo.model.Message;
import com.example.venka.demo.mongo.MessageRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MessageDAOImpl implements MessageDAO {

    private MessageRepository dbManager;

    public MessageDAOImpl(@Autowired final MessageRepository dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public void insert(Message message) {
        dbManager.save(message);
    }

    @Override
    public void delete(ObjectId id) {
        dbManager.delete(id);
    }

    @Override
    public List<Message> getAll() {
        return StreamSupport.stream(dbManager.findAll().spliterator(), false)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Message getById(ObjectId id) {
        return dbManager.findOne(id);
    }
}
