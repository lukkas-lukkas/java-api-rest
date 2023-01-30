package com.medical.api.application.shared;

import com.medical.api.domain.exceptions.DataNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GetService<Model> extends PersistenceService<Model> {

    public GetService(JpaRepository<Model, Long> repository) {
        super(repository);
    }

    public Model getById(Long id) throws DataNotFoundException {
        return this.repository.findById(id)
                .orElseThrow(DataNotFoundException::new);
    }
}
