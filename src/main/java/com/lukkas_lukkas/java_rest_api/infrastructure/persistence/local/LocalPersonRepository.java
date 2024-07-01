package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.local;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepositoryContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class LocalPersonRepository implements PersonRepositoryContract {
    private final HashMap<String, Person> people = new HashMap<>();

    public LocalPersonRepository() {
        Person person = new Person(
                "1",
                "Tony Stark",
                "tony@stark.com",
                "hash123"
        );

        this.people.put(person.getId(), person);
    }

    @Override
    public Person getById(String id) {
        return this.people.get(id);
    }

    @Override
    public void create(Person person) {
        this.people.put(person.getId(), person);
    }

    @Override
    public void update(Person person) {
        this.people.put(person.getId(), person);
    }

    @Override
    public void delete(String personId) {
        this.people.remove(personId);
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(people.values());
    }
}
