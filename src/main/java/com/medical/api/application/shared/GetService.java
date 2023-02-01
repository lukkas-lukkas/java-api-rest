package com.medical.api.application.shared;

import com.medical.api.domain.exceptions.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@AllArgsConstructor
public class GetService<Model> {

    private JpaRepository<Model, Long> repository;

    public Model getById(Long id) throws DataNotFoundException {
        return this.repository.findById(id)
                .orElseThrow(DataNotFoundException::new);
    }
}
