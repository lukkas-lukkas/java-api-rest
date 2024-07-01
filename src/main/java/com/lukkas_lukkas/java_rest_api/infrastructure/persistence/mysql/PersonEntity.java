package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.mysql;

import jakarta.persistence.*;

@Entity
public class PersonEntity {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    public PersonEntity() {}

    public PersonEntity(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
