package com.medical.api.ui.api.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateDoctorRequest (

    @NotBlank
    String name,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm,

    @NotBlank
    String specialty,

    @Valid
    CreateAddressRequest address
) {
}
