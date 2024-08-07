package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers;

import com.lukkas_lukkas.java_rest_api.application.math.MathDTO;
import com.lukkas_lukkas.java_rest_api.application.math.MathDataValidator;
import com.lukkas_lukkas.java_rest_api.application.math.MathHandler;
import com.lukkas_lukkas.java_rest_api.application.math.MathResponse;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.ValidationException;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.MathInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController implements MathInterface {

    private final MathHandler handler;
    private final MathDataValidator validator;

    public MathController(
            MathHandler handler,
            MathDataValidator validator
    ) {
        this.handler = handler;
        this.validator = validator;
    }

    @RequestMapping(
            value = "/math/{operation}/{numberOne}/{numberTwo}",
            method = RequestMethod.POST
    )
    public ResponseEntity<MathResponse> math(
            @PathVariable(value = "operation") String operation,
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws ValidationException {
        this.validator.validate(operation, numberOne, numberTwo);

        MathDTO dto = new MathDTO(operation, numberOne, numberTwo);

        MathResponse response = this.handler.handle(dto);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
