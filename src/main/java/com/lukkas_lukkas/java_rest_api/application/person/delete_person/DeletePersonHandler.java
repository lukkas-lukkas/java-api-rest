package com.lukkas_lukkas.java_rest_api.application.person.delete_person;

import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepositoryContract;
import org.springframework.stereotype.Component;

@Component
public class DeletePersonHandler {

    private final PersonRepositoryContract repository;

    public DeletePersonHandler(PersonRepositoryContract repository) {
        this.repository = repository;
    }

    public void handle(String personId) {
        this.repository.delete(personId);
    }
}
