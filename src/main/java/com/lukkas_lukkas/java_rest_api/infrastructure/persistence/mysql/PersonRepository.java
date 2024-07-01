package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.mysql;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.DataNotFoundException;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepositoryContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class PersonRepository implements PersonRepositoryContract {

    private final JpaPersonRepository jpaRepository;

    public PersonRepository(JpaPersonRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Person getById(String id) throws DataNotFoundException {
        var entity = this.jpaRepository.findById(id);

        if (entity.isEmpty()) {
            throw new DataNotFoundException("Person not found for ID: " + id);
        }

        return this.mapToPerson(entity.get());
    }

    @Override
    public void create(Person person) {
        var entity = this.mapToEntity(person);

        this.jpaRepository.save(entity);
    }

    @Override
    public void update(Person person) throws DataNotFoundException {
        this.getById(person.getId());

        var entity = this.mapToEntity(person);

        this.jpaRepository.save(entity);
    }

    @Override
    public void delete(String personId) {
        this.jpaRepository.deleteById(personId);
    }

    @Override
    public List<Person> getAll() {
        var entities = this.jpaRepository.findAll();
        return entities
                .stream()
                .map(this::mapToPerson)
                .collect(Collectors.toList());
    }

    private Person mapToPerson(PersonEntity entity) {
        return new Person(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword()
        );
    }

    private PersonEntity mapToEntity(Person person) {
        return new PersonEntity(
                person.getId(),
                person.getName(),
                person.getEmail(),
                person.getPassword()
        );
    }
}
