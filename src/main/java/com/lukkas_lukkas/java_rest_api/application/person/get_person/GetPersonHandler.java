package com.lukkas_lukkas.java_rest_api.application.person.get_person;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.DataNotFoundException;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepositoryContract;
import org.springframework.stereotype.Component;

@Component
public class GetPersonHandler {

    private final PersonRepositoryContract repository;

    public GetPersonHandler(PersonRepositoryContract repository) {
        this.repository = repository;
    }

    public Person get(String id) throws DataNotFoundException {
        return this.repository.getById(id);
    }
}
