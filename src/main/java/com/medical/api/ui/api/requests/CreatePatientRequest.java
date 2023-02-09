package com.medical.api.ui.api.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreatePatientRequest (

    @NotBlank
    String cpf,

    @NotBlank
    String name,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String phone,

    @Valid
    CreateAddressRequest address
) {
}
