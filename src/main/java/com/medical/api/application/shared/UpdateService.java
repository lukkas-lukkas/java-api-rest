package com.medical.api.application.shared;

import com.medical.api.domain.dto.ModelDto;
import com.medical.api.domain.dto.UpdateModelDto;
import com.medical.api.domain.exceptions.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@AllArgsConstructor
public class UpdateService<Model> {

    private JpaRepository<Model, Long> repository;

    public Model update(ModelDto<Model> dto, Long id) throws DataNotFoundException {
        var model = this.repository.findById(id)
                .orElseThrow(DataNotFoundException::new);

        return dto.update(model);
    }

    public Model update(UpdateModelDto<Model> dto, Long id) throws DataNotFoundException {
        var model = this.repository.findById(id)
                .orElseThrow(DataNotFoundException::new);

        return dto.update(model);
    }
}
