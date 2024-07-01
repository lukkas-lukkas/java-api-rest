package com.lukkas_lukkas.java_rest_api.infrastructure.persistence.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonRepository extends JpaRepository<PersonEntity, String> {
}
