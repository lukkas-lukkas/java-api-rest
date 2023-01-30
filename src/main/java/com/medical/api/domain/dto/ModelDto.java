package com.medical.api.domain.dto;

public interface ModelDto<Model> {

    public Model toModel();

    public Model update(Model model);
}
