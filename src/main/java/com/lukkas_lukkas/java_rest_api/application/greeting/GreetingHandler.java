package com.lukkas_lukkas.java_rest_api.application.greeting;

import com.lukkas_lukkas.java_rest_api.domain.Greeting;

public class GreetingHandler {
    private final String template = "Hello, %s!";

    public Greeting handle(String name) {
        return new Greeting(1, String.format(template, name));
    }
}
