package com.medical.api.ui.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medical.api.domain.enums.Specialty;
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
    Address address
) {

    public record Address(
        @NotBlank
        String street,

        @NotBlank
        String neighborhood,

        @NotBlank
        @JsonProperty("zip_code")
        @Pattern(regexp = "\\d{8}")
        String zipcode,

        @NotBlank
        String city,

        @NotBlank
        String state,

        String complement
    ){
    }
}
