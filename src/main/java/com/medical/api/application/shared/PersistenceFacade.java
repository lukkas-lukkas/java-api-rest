package com.medical.api.application.shared;

import com.medical.api.domain.dto.ModelDto;
import com.medical.api.domain.dto.UpdateModelDto;
import com.medical.api.domain.exceptions.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class PersistenceFacade<Model> {

    private JpaRepository<Model, Long> repository;

    public void setRepository(JpaRepository<Model, Long> repository) {
        this.repository = repository;
    }

    public Model create(ModelDto<Model> modelDto) {
        return new CreateService<Model>(this.repository).create(modelDto);
    }

    public void delete(Long id) {
        new DeleteService<Model>(this.repository).delete(id);
    }

    public Model get(Long id) throws DataNotFoundException {
        return new GetService<Model>(this.repository).getById(id);
    }

    public Page<Model> list(Pageable pageable) {
        return new ListService<Model>(this.repository).get(pageable);
    }

    public Model update(UpdateModelDto<Model> dto, Long id) throws DataNotFoundException {
        return new UpdateService<Model>(this.repository).update(dto, id);
    }

    public Model update(ModelDto<Model> dto, Long id) throws DataNotFoundException {
        return new UpdateService<Model>(this.repository).update(dto, id);
    }
}
