package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers.person;

import com.lukkas_lukkas.java_rest_api.application.person.get_person.GetPersonHandler;
import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person/{id}")
public class GetPersonController {

    private final GetPersonHandler handler;

    public GetPersonController(GetPersonHandler handler) {
        this.handler = handler;
    }

    @GetMapping
    public ResponseEntity<?> get(@PathVariable(value = "id") String id) {
        Person person = this.handler.get(id);

        if (null == person) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PersonView view = new PersonView(person);
        return new ResponseEntity<>(view, HttpStatus.OK);
    }
}
