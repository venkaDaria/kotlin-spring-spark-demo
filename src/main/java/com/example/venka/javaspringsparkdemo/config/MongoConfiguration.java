package com.example.venka.javaspringsparkdemo.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

    @Bean
    public MongoDatabase getMongoDatabase(@Autowired MongoProperties mongoProperties) {
        return new MongoClient(mongoProperties.getHost(), mongoProperties.getPort())
                .getDatabase(mongoProperties.getDatabase());
    }
}
