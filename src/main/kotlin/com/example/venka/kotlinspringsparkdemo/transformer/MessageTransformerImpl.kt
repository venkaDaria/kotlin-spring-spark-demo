package com.example.venka.kotlinspringsparkdemo.transformer

import com.example.venka.kotlinspringsparkdemo.model.Message
import org.bson.Document
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

@Component
class MessageTransformerImpl : MessageTransformer {

    override fun toDocument(message: Message): Document {
        val document = Document()
        document.append("text", message.text)
        return document
    }

    override fun fromDocument(document: Document): Message {
        return Message(document.getObjectId("_id")!!, document.getString("text"))
    }

    override fun toDocument(id: ObjectId): Document {
        val document = Document()
        document.append("_id", id)
        return document
    }
}
