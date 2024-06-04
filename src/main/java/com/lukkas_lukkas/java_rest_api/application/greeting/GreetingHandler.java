package com.lukkas_lukkas.java_rest_api.application.greeting;

import com.lukkas_lukkas.java_rest_api.domain.Greeting;

import java.util.UUID;

public class GreetingHandler {
    private final String template = "Hello, %s!";

    public Greeting handle(String name) {
        return new Greeting(
                UUID.randomUUID(),
                String.format(template, name)
        );
    }
}
