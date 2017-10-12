package com.example.venka.kotlinspringsparkdemo.mongo

import org.bson.Document

interface DatabaseManager {

    val all: List<Document>

    fun insert(document: Document)

    fun delete(document: Document)

    fun getById(document: Document): Document
}
