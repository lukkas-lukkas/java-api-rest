package com.lukkas_lukkas.java_rest_api.infrastructure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("greeting")
public class GreetingConfig {
    private String english;

    public GreetingConfig() {}

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getEnglish() {
        return english;
    }
}
