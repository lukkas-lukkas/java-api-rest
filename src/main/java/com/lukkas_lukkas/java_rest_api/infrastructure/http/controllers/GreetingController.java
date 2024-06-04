package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers;

import com.lukkas_lukkas.java_rest_api.domain.Greeting;
import com.lukkas_lukkas.java_rest_api.application.greeting.GreetingHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingHandler handler;

    public GreetingController(GreetingHandler handler) {
        this.handler = handler;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return this.handler.handle(name);
    }
}
