package com.medical.api.ui.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medical.api.domain.enums.Specialty;
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
    Address address
) {
    public record Address(
        String street,
        String neighborhood,

        @JsonProperty("zip_code")
        @Pattern(regexp = "\\d{8}")
        String zipcode,

        String city,
        String state,
        String complement
    ){
    }
}
