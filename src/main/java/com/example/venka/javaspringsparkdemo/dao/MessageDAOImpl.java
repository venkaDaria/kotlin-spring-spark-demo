package com.example.venka.javaspringsparkdemo.dao;

import com.example.venka.javaspringsparkdemo.model.Message;
import com.example.venka.javaspringsparkdemo.mongo.DatabaseManager;
import com.example.venka.javaspringsparkdemo.transformer.MessageTransformer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageDAOImpl implements MessageDAO {

    private DatabaseManager dbManager;

    private MessageTransformer messageTransformer;

    public MessageDAOImpl(
            @Autowired final DatabaseManager dbManager,
            @Autowired final MessageTransformer messageTransformer
    ) {
        this.dbManager = dbManager;
        this.messageTransformer = messageTransformer;
    }

    @Override
    public void insert(Message message) {
        dbManager.insert(messageTransformer.toDocument(message));
    }

    @Override
    public void delete(ObjectId id) {
        dbManager.delete(messageTransformer.toDocument(id));
    }

    @Override
    public List<Message> getAll() {
        return dbManager.getAll().stream().map(messageTransformer::fromDocument)
                .collect(Collectors.toList());
    }

    @Override
    public Message getById(ObjectId id) {
        return messageTransformer.fromDocument(dbManager.getById(messageTransformer.toDocument(id)));
    }
}
