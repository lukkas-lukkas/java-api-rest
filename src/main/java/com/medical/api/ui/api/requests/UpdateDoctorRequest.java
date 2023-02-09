package com.medical.api.ui.api.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record UpdateDoctorRequest(

    String name,

    @Email
    String email,

    @Pattern(regexp = "\\d{4,6}")
    String crm,

    String specialty,

    @Valid
    UpdateAddressRequest address
) {
}
