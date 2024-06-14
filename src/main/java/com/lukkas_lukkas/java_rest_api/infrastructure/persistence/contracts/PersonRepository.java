package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository {
    Person getById(String id);

    void create(Person person);

    void update(Person person);

    void delete(String personId);
}
