package com.medical.api.domain.models;

import com.medical.api.domain.valueObject.Address;
import lombok.Data;

@Data
public class Patient {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private Address address;
}
