package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers.person;

import com.lukkas_lukkas.java_rest_api.application.person.get_people.GetPeopleHandler;
import com.lukkas_lukkas.java_rest_api.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class GetPeopleController {

    private final GetPeopleHandler handler;

    public GetPeopleController(GetPeopleHandler handler) {
        this.handler = handler;
    }

    @GetMapping
    public ResponseEntity<List<Person>> get() {
        var people = this.handler.handle();

        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}
