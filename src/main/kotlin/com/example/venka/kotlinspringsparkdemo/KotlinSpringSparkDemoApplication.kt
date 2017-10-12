package com.example.venka.kotlinspringsparkdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringSparkDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringSparkDemoApplication::class.java, *args)
}