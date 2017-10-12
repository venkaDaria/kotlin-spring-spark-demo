package com.example.venka.javaspringsparkdemo.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class DatabaseManagerImpl implements DatabaseManager {

    private final MongoCollection<Document> COLLECTION;

    private DatabaseManagerImpl(@Autowired MongoDatabase mongoDatabase) {
        COLLECTION = mongoDatabase.getCollection("messages");
    }

    @Override
    public void insert(final Document document) {
        COLLECTION.insertOne(document);
    }

    @Override
    public void delete(final Document document) {
        COLLECTION.deleteOne(document);
    }

    @Override
    public List<Document> getAll() {
        return COLLECTION.find().into(new ArrayList<>());
    }

    @Override
    public Document getById(final Document document) {
        return COLLECTION.find(document).first();
    }
}