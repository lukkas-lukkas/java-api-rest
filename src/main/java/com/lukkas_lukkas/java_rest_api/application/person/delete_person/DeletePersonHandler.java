package com.lukkas_lukkas.java_rest_api.application.person.delete_person;

import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class DeletePersonHandler {

    private final PersonRepository repository;

    public DeletePersonHandler(PersonRepository repository) {
        this.repository = repository;
    }

    public void handle(String personId) {
        this.repository.delete(personId);
    }
}
