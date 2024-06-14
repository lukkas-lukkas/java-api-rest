package com.lukkas_lukkas.java_rest_api.application.person.get_people;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPeopleHandler {
    private final PersonRepository repository;

    public GetPeopleHandler(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> handle() {
        return this.repository.getAll();
    }
}
