package com.lukkas_lukkas.java_rest_api.application.greeting;

import com.lukkas_lukkas.java_rest_api.domain.Greeting;
import com.lukkas_lukkas.java_rest_api.infrastructure.configuration.GreetingConfig;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GreetingHandler {
    private final GreetingConfig config;

    private final String template = "%s, %s!";

    public GreetingHandler(GreetingConfig config) {
        this.config = config;
    }

    public Greeting handle(String name) {
        return new Greeting(
                UUID.randomUUID(),
                String.format(template, this.config.getEnglish(), name)
        );
    }
}
