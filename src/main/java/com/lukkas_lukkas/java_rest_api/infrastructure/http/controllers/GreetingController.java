package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers;

import com.lukkas_lukkas.java_rest_api.domain.Greeting;
import com.lukkas_lukkas.java_rest_api.application.greeting.GreetingHandler;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.GreetingInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController implements GreetingInterface {

    private final GreetingHandler handler;

    public GreetingController(GreetingHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return this.handler.handle(name);
    }
}
