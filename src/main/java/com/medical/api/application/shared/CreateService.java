package com.medical.api.application.shared;

import com.medical.api.domain.dto.ModelDto;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateService<Model> {

    private JpaRepository<Model, Long> repository;

    public Model create (ModelDto<Model> dto) {
        var model = dto.toModel();

        this.repository.save(model);

        return model;
    }
}
