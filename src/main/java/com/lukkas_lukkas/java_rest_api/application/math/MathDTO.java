package com.lukkas_lukkas.java_rest_api.application.math;

import com.lukkas_lukkas.java_rest_api.domain.MathOperation;

public class MathDTO {
    public final MathOperation operation;
    public final Integer numberOne;
    public final Integer numberTwo;

    public MathDTO(
            String operation,
            String numberOne,
            String numberTwo
    ) {
        this.operation = MathOperation.valueOf(operation.toUpperCase());
        this.numberOne = Integer.parseInt(numberOne);
        this.numberTwo = Integer.parseInt(numberTwo);
    }
}
