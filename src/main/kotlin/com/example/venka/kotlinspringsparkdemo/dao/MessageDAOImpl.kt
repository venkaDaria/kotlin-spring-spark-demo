package com.example.venka.kotlinspringsparkdemo.dao;

import com.example.venka.kotlinspringsparkdemo.model.Message
import com.example.venka.kotlinspringsparkdemo.mongo.DatabaseManager
import com.example.venka.kotlinspringsparkdemo.transformer.MessageTransformer
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageDAOImpl(
        @param:Autowired private val dbManager: DatabaseManager,
        @param:Autowired private val messageTransformer: MessageTransformer
) : MessageDAO {

    override fun insert(message: Message) {
        dbManager.insert(messageTransformer.toDocument(message))
    }

    override fun delete(id: ObjectId) {
        dbManager.delete(messageTransformer.toDocument(id))
    }

    override val all: List<Message>
        get() = dbManager.all.map(messageTransformer::fromDocument)

    override fun getById(id: ObjectId): Message {
        return messageTransformer.fromDocument(dbManager.getById(messageTransformer.toDocument(id)))
    }
}