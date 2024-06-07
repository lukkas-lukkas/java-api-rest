package com.lukkas_lukkas.java_rest_api.application.person.get_person;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class GetPersonHandler {

    private final PersonRepository repository;

    public GetPersonHandler(PersonRepository repository) {
        this.repository = repository;
    }

    public Person get(String id) {
        return this.repository.getById(id);
    }
}
