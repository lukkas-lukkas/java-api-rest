package com.medical.api.ui.api.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UpdatePatientRequest (

    String cpf,
    String name,

    @Email
    String email,

    String phone,

    @Valid
    UpdateAddressRequest address
) {
}
