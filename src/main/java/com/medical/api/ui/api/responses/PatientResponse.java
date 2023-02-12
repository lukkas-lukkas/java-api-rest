package com.medical.api.ui.api.responses;

public record PatientResponse (

    Long id,
    String name,
    String email,
    String phone,
    String cpf
) {
}
