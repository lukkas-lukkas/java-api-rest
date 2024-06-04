package com.lukkas_lukkas.java_rest_api.domain;

import java.util.UUID;

public class Greeting {
    private final UUID id;
    private final String content;

    public Greeting(UUID id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public UUID getId() {
        return id;
    }
}
