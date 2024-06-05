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

        if (isNegativeNumber(numberOne)) {
            errors.add("Number one is not a positive number");
        }

        if (isNegativeNumber(numberTwo)) {
            errors.add("Number two is not a positive number");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private boolean isNegativeNumber(String string) {
        try {
            double num = Double.parseDouble(string);
            return !(num > 0);
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
