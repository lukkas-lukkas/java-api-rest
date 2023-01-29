package com.medical.api.domain.valueObject;

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
}
