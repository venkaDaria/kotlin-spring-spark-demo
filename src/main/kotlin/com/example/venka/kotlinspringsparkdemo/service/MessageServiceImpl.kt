package com.example.venka.kotlinspringsparkdemo.service

import com.example.venka.kotlinspringsparkdemo.dao.MessageDAO
import com.example.venka.kotlinspringsparkdemo.model.Message
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(@param:Autowired private val messageDAO: MessageDAO) : MessageService {

    override val all: List<Message>
        get() = messageDAO.all

    override fun insert(message: Message) {
        messageDAO.insert(message)
    }

    override fun delete(id: ObjectId) {
        messageDAO.delete(id)
    }

    override fun getById(id: ObjectId): Message {
        return messageDAO.getById(id)
    }
}
