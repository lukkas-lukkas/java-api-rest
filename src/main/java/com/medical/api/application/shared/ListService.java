package com.medical.api.application.shared;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@AllArgsConstructor
public class ListService<Model> {

    private JpaRepository<Model, Long> repository;

    public Page<Model> get(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
