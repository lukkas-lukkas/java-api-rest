package com.medical.api.domain.valueObject;

import lombok.Data;

@Data
public class Address {

    private String street;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String complement;
}
