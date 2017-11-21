package com.example.venka.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "index";
    }
}