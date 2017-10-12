package com.example.venka.javaspringsparkdemo.transformer;

import com.example.venka.javaspringsparkdemo.model.Message;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class MessageTransformerImpl implements MessageTransformer {

    public Document toDocument(final Message message) {
        final Document document = new Document();
        document.append("text", message.getText());
        return document;
    }

    public Message fromDocument(final Document document) {
        final Message message = new Message();
        message.setId(document.getObjectId("_id"));
        message.setText(document.getString("text"));
        return message;
    }

    @Override
    public Document toDocument(ObjectId id) {
        final Document document = new Document();
        document.append("_id", id);
        return document;
    }
}
