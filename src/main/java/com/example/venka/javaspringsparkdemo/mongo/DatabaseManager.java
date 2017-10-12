package com.example.venka.javaspringsparkdemo.mongo;

import org.bson.Document;

import java.util.List;

public interface DatabaseManager {

    void insert(final Document document);

    void delete(final Document document);

    List<Document> getAll();

    Document getById(final Document document);
}
