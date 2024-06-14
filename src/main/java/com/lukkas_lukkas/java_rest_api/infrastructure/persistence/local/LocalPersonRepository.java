package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.local;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Primary
public class LocalPersonRepository implements PersonRepository {
    private final HashMap<String, Person> people = new HashMap<>();

    public LocalPersonRepository() {
        Person person = new Person(
                "1",
                "Tony Stark",
                "tony@stark.com",
                "hash123"
        );

        this.people.put(person.id(), person);
    }

    @Override
    public Person getById(String id) {
        return this.people.get(id);
    }

    @Override
    public void create(Person person) {
        this.people.put(person.id(), person);
    }

    @Override
    public void delete(String personId) {
        this.people.remove(personId);
    }
}
