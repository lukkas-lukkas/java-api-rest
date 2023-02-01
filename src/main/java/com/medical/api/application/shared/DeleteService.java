package com.medical.api.application.shared;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@AllArgsConstructor
public class DeleteService<Model> {

    private JpaRepository<Model, Long> repository;

    public void delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }
    }
}
