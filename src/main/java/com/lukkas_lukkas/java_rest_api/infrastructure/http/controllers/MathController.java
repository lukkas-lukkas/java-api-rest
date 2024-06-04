package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(
            value = "/math/{operation}/{numberOne}/{numberTwo}",
            method = RequestMethod.POST
    )
    public Double math(
            @PathVariable(value = "operation") String operation,
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        return 1D;
    }
}
