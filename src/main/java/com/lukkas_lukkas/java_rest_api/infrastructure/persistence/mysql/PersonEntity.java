package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.mysql;

import jakarta.persistence.*;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;
}
