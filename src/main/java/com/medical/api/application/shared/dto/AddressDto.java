package com.medical.api.application.shared.dto;

import com.medical.api.infrastructure.database.entity.AddressEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDto (

    @NotBlank
    String street,

    @NotBlank
    String neighborhood,

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String zipcode,

    @NotBlank
    String city,

    @NotBlank
    String state,

    String complement
) {
    public AddressEntity toAddress() {
        return new AddressEntity(
            this.street,
            this.neighborhood,
            this.zipcode,
            this.city,
            this.state,
            this.complement
        );
    }
}
