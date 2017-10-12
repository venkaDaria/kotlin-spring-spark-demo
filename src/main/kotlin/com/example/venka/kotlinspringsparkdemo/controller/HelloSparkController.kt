package com.example.venka.kotlinspringsparkdemo.controller

import com.example.venka.kotlinspringsparkdemo.service.MessageService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import spark.Request
import spark.Response
import spark.Spark.get
import spark.Spark.options
import spark.kotlin.before

@Controller
class HelloSparkController(@Autowired messageService: MessageService) {

    init {
        val gson = Gson()

        get("/hello", { _: Request, _: Response -> messageService.all[0] }) { it ->
            gson.toJson(it)
        }

        get("/nothing") { _: Request, res: Response ->
            res.status(404)
            "Oops, we couldn't find what you're looking for"
        }

        get("/saymy/:name") { req: Request, _: Response ->
            req.params(":name")
        }

        get("/redirect") { _: Request, res: Response ->
            res.redirect("/hello")
        }

        enableCORS()
    }

    // Enables CORS on requests. This method is an initialization method and should be called once.
    private final fun enableCORS() {

        options("/*") { request, response ->

            val accessControlRequestHeaders = request.headers("Access-Control-Request-Headers")
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders)
            }

            val accessControlRequestMethod = request.headers("Access-Control-Request-Method")
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod)
            }

            "OK"
        }

        before {
            response.header("Access-Control-Allow-Origin", "*")
            response.header("Access-Control-Request-Method", "*")
            response.header("Access-Control-Allow-Headers", "*")

            response.type("application/json")
        }
    }
}