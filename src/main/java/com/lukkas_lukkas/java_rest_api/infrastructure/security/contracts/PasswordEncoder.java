package com.lukkas_lukkas.java_rest_api.infrastructure.security.contracts;

import org.springframework.stereotype.Component;

@Component
public interface PasswordEncoder {
    public String encode(String value);
}
