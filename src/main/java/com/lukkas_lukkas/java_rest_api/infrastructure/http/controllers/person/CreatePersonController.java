package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers.person;

import com.lukkas_lukkas.java_rest_api.application.person.create_person.CreatePersonHandler;
import com.lukkas_lukkas.java_rest_api.application.person.create_person.PersonDTO;
import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class CreatePersonController {

    private final CreatePersonHandler handler;

    public CreatePersonController(CreatePersonHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersonDTO dto) {
        Person person = this.handler.create(dto);

        PersonView view = new PersonView(person);
        return new ResponseEntity<>(view, HttpStatus.CREATED);
    }
}
