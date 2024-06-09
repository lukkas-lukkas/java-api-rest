package com.lukkas_lukkas.java_rest_api.infrastructure.security;

import com.lukkas_lukkas.java_rest_api.infrastructure.security.contracts.PasswordEncoder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MockPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String value) {
        return new StringBuilder(value).reverse().toString();
    }
}
