package com.lukkas_lukkas.java_rest_api.application.math;

import com.lukkas_lukkas.java_rest_api.domain.MathOperation;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MathDataValidator {
    public void validate(
            String operation,
            String numberOne,
            String numberTwo
    ) throws ValidationException {
        List<String> errors = new ArrayList<>();

        try {
            MathOperation.valueOf(operation.toUpperCase());
        } catch (IllegalArgumentException exception) {
            errors.add("Invalid math operation");
        }

        if (isNotNumber(numberOne)) {
            errors.add("Number one is not a valid number");
        }

        if (isNotNumber(numberTwo)) {
            errors.add("Number two is not a valid number");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private boolean isNotNumber(String string) {
        try {
            Integer.parseInt(string);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
