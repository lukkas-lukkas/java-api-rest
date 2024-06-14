package com.lukkas_lukkas.java_rest_api.infrastructure.http.controllers.person;

import com.lukkas_lukkas.java_rest_api.application.person.delete_person.DeletePersonHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/{id}")
public class DeletePersonController {

    private final DeletePersonHandler handler;

    public DeletePersonController(DeletePersonHandler handler) {
        this.handler = handler;
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
        this.handler.handle(id);
        return ResponseEntity.noContent().build();
    }
}
