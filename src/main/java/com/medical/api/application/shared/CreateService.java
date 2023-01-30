package com.medical.api.application.shared;

import com.medical.api.domain.dto.ModelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateService<Model> extends PersistenceService<Model> {

    public CreateService(JpaRepository<Model, Long> repository) {
        super(repository);
    }

    public Model create (ModelDto<Model> dto) {
        var model = dto.toModel();

        this.repository.save(model);

        return model;
    }
}
