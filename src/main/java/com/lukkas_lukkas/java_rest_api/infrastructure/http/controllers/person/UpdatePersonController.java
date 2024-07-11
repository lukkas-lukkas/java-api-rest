package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers.person;

import com.lukkas_lukkas.java_rest_api.application.person.update_person.UpdatePersonDTO;
import com.lukkas_lukkas.java_rest_api.application.person.update_person.UpdatePersonHandler;
import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.DataNotFoundException;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.forms.person.UpdatePersonForm;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person/{id}")
public class UpdatePersonController {

    private final UpdatePersonHandler handler;

    public UpdatePersonController(UpdatePersonHandler handler) {
        this.handler = handler;
    }

    @PatchMapping
    public ResponseEntity<?> create(@Valid @RequestBody UpdatePersonForm body, @PathVariable(value = "id") String id) {
        try {
            UpdatePersonDTO dto = new UpdatePersonDTO(
                    id,
                    body.name,
                    body.email
            );
            Person person = this.handler.handle(dto);

            PersonView view = new PersonView(person);
            return ResponseEntity.ok(view);
        } catch (DataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
