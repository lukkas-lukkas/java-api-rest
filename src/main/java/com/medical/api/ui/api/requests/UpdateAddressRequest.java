package com.medical.api.ui.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;

public record UpdateAddressRequest(

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
