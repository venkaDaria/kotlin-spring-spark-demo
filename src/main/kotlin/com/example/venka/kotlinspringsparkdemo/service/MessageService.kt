package com.example.venka.kotlinspringsparkdemo.service

import com.example.venka.kotlinspringsparkdemo.model.Message
import org.bson.types.ObjectId

interface MessageService {

    val all: List<Message>

    fun insert(message: Message)

    fun delete(id: ObjectId)

    fun getById(id: ObjectId): Message
}
