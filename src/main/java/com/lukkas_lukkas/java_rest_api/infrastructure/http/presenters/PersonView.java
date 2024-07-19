package com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters;

import com.lukkas_lukkas.java_rest_api.domain.Person;
import io.swagger.v3.oas.annotations.media.Schema;

public class PersonView  {

    public final String name;

    @Schema(
            type = "string",
            format = "uuid"
    )
    public final String id;

    @Schema(
            type = "string",
            format = "email"
    )
    public final String email;

    public PersonView(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
    }
}
