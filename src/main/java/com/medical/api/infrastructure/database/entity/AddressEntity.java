package com.medical.api.infrastructure.database.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {

    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String complement;
}
