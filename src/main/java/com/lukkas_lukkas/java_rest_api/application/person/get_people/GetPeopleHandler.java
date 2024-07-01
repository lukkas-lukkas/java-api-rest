package com.lukkas_lukkas.java_rest_api.application.person.get_people;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepositoryContract;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPeopleHandler {
    private final PersonRepositoryContract repository;

    public GetPeopleHandler(PersonRepositoryContract repository) {
        this.repository = repository;
    }

    public List<Person> handle() {
        return this.repository.getAll();
    }
}
