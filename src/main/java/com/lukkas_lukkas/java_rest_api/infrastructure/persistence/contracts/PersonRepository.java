package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository {
    public Person getById(String id);

    public void create(Person person);
}
