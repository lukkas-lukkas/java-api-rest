package com.medical.api.ui.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAddressRequest(
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
) {
}
