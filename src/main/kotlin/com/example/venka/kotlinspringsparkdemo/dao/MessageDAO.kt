package com.example.venka.kotlinspringsparkdemo.dao

import com.example.venka.kotlinspringsparkdemo.model.Message
import org.bson.types.ObjectId

interface MessageDAO {

    val all: List<Message>

    fun insert(message: Message)

    fun delete(id: ObjectId)

    fun getById(id: ObjectId): Message
}
