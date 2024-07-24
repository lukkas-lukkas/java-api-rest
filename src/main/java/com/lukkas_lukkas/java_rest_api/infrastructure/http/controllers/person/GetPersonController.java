package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers.person;

import com.lukkas_lukkas.java_rest_api.application.person.get_person.GetPersonHandler;
import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.DataNotFoundException;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.person.GetPersonInterface;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person/{id}")
public class GetPersonController implements GetPersonInterface {

    private final GetPersonHandler handler;

    public GetPersonController(GetPersonHandler handler) {
        this.handler = handler;
    }

    @GetMapping
    public ResponseEntity<PersonView> get(@PathVariable(value = "id") String id) {
        try {
            Person person = this.handler.get(id);

            PersonView view = new PersonView(person);
            return ResponseEntity.ok(view);
        } catch (DataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
