package com.lukkas_lukkas.java_rest_api.application.math;

import com.lukkas_lukkas.java_rest_api.application.math.calculators.CalculatorFactory;
import org.springframework.stereotype.Component;

@Component
public class MathHandler {
    private final CalculatorFactory calculatorFactory;

    public MathHandler(CalculatorFactory calculatorFactory) {
        this.calculatorFactory = calculatorFactory;
    }

    public MathResponse handle(MathDTO dto) {
        var calculator = this.calculatorFactory.factory(dto.operation);
        Double result = calculator.calculate(
                dto.numberOne,
                dto.numberTwo
        );

        return new MathResponse(
                dto,
                result
        );
    }
}
