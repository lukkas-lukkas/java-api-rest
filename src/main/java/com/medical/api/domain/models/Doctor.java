package com.medical.api.domain.models;

import com.medical.api.domain.enums.Specialty;
import com.medical.api.domain.valueObject.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Doctor {

    private Long id = null;
    private String name;
    private String email;
    private String crm;
    private Specialty specialty;
    private Address address;
}
