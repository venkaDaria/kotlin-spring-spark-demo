package com.example.venka.javaspringsparkdemo.transformer;

import com.example.venka.javaspringsparkdemo.model.Message;
import org.bson.Document;
import org.bson.types.ObjectId;

public interface MessageTransformer {

    Document toDocument(final Message message);

    Message fromDocument(final Document document);

    Document toDocument(final ObjectId id);
}
