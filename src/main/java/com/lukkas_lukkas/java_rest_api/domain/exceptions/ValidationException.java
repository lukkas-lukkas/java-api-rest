package com.lukkas_lukkas.java_rest_api.domain.exceptions;

import java.util.List;

public class ValidationException extends Exception {
    private final List<String> messages;

    public ValidationException(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return this.messages;
    }
}
