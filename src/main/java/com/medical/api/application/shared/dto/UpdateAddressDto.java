package com.medical.api.application.shared.dto;

import com.medical.api.infrastructure.database.entity.AddressEntity;
import jakarta.validation.constraints.Pattern;

public record UpdateAddressDto(

    @Pattern(regexp = "\\d{8}")
    String zipcode,

    String street,
    String neighborhood,
    String city,
    String state,
    String complement
) {
    public AddressEntity updateAddress(AddressEntity address) {
        if (this.zipcode != null) {
            address.setZipcode(this.zipcode);
        }

        if (this.street != null) {
            address.setStreet(this.street);
        }

        if (this.neighborhood != null) {
            address.setNeighborhood(this.neighborhood);
        }

        if (this.city != null) {
            address.setCity(this.city);
        }

        if (this.state != null) {
            address.setState(this.state);
        }

        if (this.complement != null) {
            address.setComplement(this.complement);
        }

        return address;
    }
}
