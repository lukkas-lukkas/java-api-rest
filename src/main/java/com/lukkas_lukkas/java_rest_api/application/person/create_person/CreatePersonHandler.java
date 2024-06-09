package com.lukkas_lukkas.java_rest_api.application.person.create_person;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepository;
import com.lukkas_lukkas.java_rest_api.infrastructure.security.contracts.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreatePersonHandler {

    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;

    public CreatePersonHandler(
            PersonRepository repository,
            PasswordEncoder passwordEncoder
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    public Person create(PersonDTO dto) {
        Person person = new Person(
                UUID.randomUUID().toString(),
                dto.name(),
                dto.email(),
                this.passwordEncoder.encode(dto.password())
        );
        this.repository.create(person);

        return person;
    }
}
