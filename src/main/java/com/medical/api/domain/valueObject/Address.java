package com.medical.api.domain.valueObject;

import com.medical.api.application.shared.dto.AddressDto;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String complement;

    public Address(AddressDto addressDto) {
        this.street = addressDto.street();
        this.neighborhood = addressDto.neighborhood();
        this.zipcode = addressDto.zipcode();
        this.city = addressDto.city();
        this.state = addressDto.state();
        this.complement = addressDto.complement();
    }
}
