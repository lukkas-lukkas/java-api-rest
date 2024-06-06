package com.lukkas_lukkas.java_rest_api.application.math.calculators;

public class SumCalculator implements Calculator {
    @Override
    public Double calculate(Integer numberOne, Integer numberTwo) {
        return (double) (numberOne + numberTwo);
    }
}
