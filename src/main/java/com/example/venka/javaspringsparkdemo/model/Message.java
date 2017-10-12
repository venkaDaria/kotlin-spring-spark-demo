package com.example.venka.javaspringsparkdemo.model;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Message {

    private ObjectId id;

    private String text;
}
