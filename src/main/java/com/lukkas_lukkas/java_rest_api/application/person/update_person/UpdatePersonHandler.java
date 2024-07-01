package com.lukkas_lukkas.java_rest_api.application.person.update_person;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.DataNotFoundException;
import com.lukkas_lukkas.java_rest_api.infrastructure.persistence.contracts.PersonRepositoryContract;
import org.springframework.stereotype.Component;

@Component
public class UpdatePersonHandler {

    private final PersonRepositoryContract repository;

    public UpdatePersonHandler(PersonRepositoryContract repository) {
        this.repository = repository;
    }

    public Person handle(UpdatePersonDTO dto) throws DataNotFoundException {
        Person person = this.repository.getById(dto.id());

        if (person == null) {
            return null;
        }

        if (dto.name() != null) {
            person.setName(dto.name());
        }

        if (dto.email() != null) {
            person.setEmail(dto.email());
        }

        this.repository.update(person);

        return person;
    }
}
