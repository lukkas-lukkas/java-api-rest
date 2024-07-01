package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.DataNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonRepositoryContract {
    Person getById(String id) throws DataNotFoundException;

    void create(Person person);

    void update(Person person) throws DataNotFoundException;

    void delete(String personId);

    List<Person> getAll();
}
