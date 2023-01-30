package com.medical.api.application.shared;

import org.springframework.data.jpa.repository.JpaRepository;

public class PersistenceServiceBuilder<Model> {

    private final JpaRepository<Model, Long> repository;

    public PersistenceServiceBuilder(JpaRepository<Model, Long> repository) {
        this.repository = repository;
    }

    public CreateService<Model> getCreateService() {
        return new CreateService<Model>(this.repository);
    }

    public DeleteService<Model> getDeleteService() {
        return new DeleteService<>(this.repository);
    }

    public GetService<Model> getGetService() {
        return new GetService<Model>(this.repository);
    }

    public ListService<Model> getListService() {
        return new ListService<Model>(this.repository);
    }

    public UpdateService<Model> getUpdateService() {
        return new UpdateService<Model>(this.repository);
    }
}
