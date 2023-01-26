package com.medical.api.domain.valueObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String complement;

    public Address (com.medical.api.domain.dto.Address dto) {
        this.street = dto.street();
        this.neighborhood = dto.neighborhood();
        this.zipcode = dto.zipcode();
        this.city = dto.city();
        this.state = dto.state();
        this.complement = dto.complement();
    }
}
