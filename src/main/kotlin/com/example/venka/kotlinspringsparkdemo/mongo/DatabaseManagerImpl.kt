package com.example.venka.kotlinspringsparkdemo.mongo

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DatabaseManagerImpl(@Autowired private val mongoDatabase: MongoDatabase) : DatabaseManager {
    private final val collection: MongoCollection<Document> = mongoDatabase.getCollection("messages")

    override val all: List<Document>
        get() = collection.find().into(ArrayList())

    override fun insert(document: Document) {
        collection.insertOne(document)
    }

    override fun delete(document: Document) {
        collection.deleteOne(document)
    }

    override fun getById(document: Document): Document {
        return collection.find(document).first()
    }

}