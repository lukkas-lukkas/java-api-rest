package com.medical.api.domain.dto;

public interface ModelDto<Model> {

    public Model toModel();

    //Atualizar todas as informações do modelo
    public Model update(Model model);
}
