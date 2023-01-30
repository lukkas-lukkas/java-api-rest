package com.medical.api.application.shared;

import org.springframework.data.jpa.repository.JpaRepository;

abstract public class PersistenceService<Model> {

    protected final JpaRepository<Model, Long> repository;

    public PersistenceService (JpaRepository<Model, Long> repository) {
        this.repository = repository;
    }
}
