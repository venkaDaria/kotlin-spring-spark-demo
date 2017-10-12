package com.example.venka.kotlinspringsparkdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HelloSpringController {

    @RequestMapping("/hello")
    fun hello(): String {
        return "index"
    }
}
