package com.lukkas_lukkas.java_rest_api.application.math.calculators;

import com.lukkas_lukkas.java_rest_api.domain.MathOperation;
import org.springframework.stereotype.Component;

@Component
public class CalculatorFactory {
    public Calculator factory(MathOperation operation) {
        return switch (operation) {
            case DIV -> new DivCalculator();
            case MULT -> new MultiplyCalculator();
            case SUM -> new SumCalculator();
            case SUB -> new SubCalculator();
        };
    }
}
