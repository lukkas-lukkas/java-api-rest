package com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters;

import com.lukkas_lukkas.java_rest_api.domain.Person;

public class PersonView  {
    public final String id;
    public final String name;
    public final String email;

    public PersonView(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
    }
}
