package com.medical.api.application.shared;

import com.medical.api.domain.dto.ModelDto;
import com.medical.api.domain.dto.UpdateModelDto;
import com.medical.api.domain.exceptions.DataNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateService<Model> extends PersistenceService<Model> {

    public UpdateService(JpaRepository<Model, Long> repository) {
        super(repository);
    }

    public Model update(ModelDto<Model> dto, Long id) throws DataNotFoundException {
        var model = this.repository.findById(id)
                .orElseThrow(DataNotFoundException::new);

        return dto.update(model);
    }

    public Model update(UpdateModelDto<Model> dto, Long id) throws DataNotFoundException {
        var model = repository.findById(id)
                .orElseThrow(DataNotFoundException::new);

        return dto.update(model);
    }
}
