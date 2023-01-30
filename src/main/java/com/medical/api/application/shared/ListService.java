package com.medical.api.application.shared;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ListService<Model> extends PersistenceService<Model> {

    public ListService(JpaRepository<Model, Long> repository) {
        super(repository);
    }

    public Page<Model> get(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
