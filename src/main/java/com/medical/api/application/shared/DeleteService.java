package com.medical.api.application.shared;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteService<Model> extends PersistenceService<Model> {

    public DeleteService(JpaRepository<Model, Long> repository) {
        super(repository);
    }

    public void delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }
    }
}
