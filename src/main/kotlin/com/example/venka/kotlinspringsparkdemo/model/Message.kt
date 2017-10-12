package com.example.venka.kotlinspringsparkdemo.model

import org.bson.types.ObjectId

data class Message(var id: ObjectId, var text: String)