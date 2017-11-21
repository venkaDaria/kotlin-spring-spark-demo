package com.example.venka.demo.service;

import com.example.venka.demo.model.Message;
import org.bson.types.ObjectId;

import java.util.List;

public interface MessageService {

    void insert(final Message message);

    void delete(final ObjectId id);

    List<Message> getAll();

    Message getById(final ObjectId id);
}
