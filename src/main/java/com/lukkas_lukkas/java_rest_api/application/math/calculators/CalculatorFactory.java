package com.lukkas_lukkas.java_rest_api.application.math.calculators;

import com.lukkas_lukkas.java_rest_api.domain.MathOperation;
import org.springframework.stereotype.Component;

@Component
public class CalculatorFactory {
    public Calculator factory(MathOperation operation) {
        return switch (operation) {
            case MathOperation.DIV -> new DivCalculator();
            case MathOperation.MULT -> new MultiplyCalculator();
            case MathOperation.SUM -> new SumCalculator();
            case MathOperation.SUB -> new SubCalculator();
        };
    }
}
