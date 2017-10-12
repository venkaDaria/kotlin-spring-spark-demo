package com.example.venka.kotlinspringsparkdemo.config

import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoConfiguration {

    @Bean
    fun getMongoDatabase(@Autowired mongoProperties: MongoProperties): MongoDatabase {
        return MongoClient(mongoProperties.host, mongoProperties.port!!)
                .getDatabase(mongoProperties.database)
    }
}
