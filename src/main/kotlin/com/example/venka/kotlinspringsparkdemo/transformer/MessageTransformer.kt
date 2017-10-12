package com.example.venka.kotlinspringsparkdemo.transformer

import com.example.venka.kotlinspringsparkdemo.model.Message
import org.bson.Document
import org.bson.types.ObjectId

interface MessageTransformer {

    fun toDocument(message: Message): Document

    fun fromDocument(document: Document): Message

    fun toDocument(id: ObjectId): Document
}
