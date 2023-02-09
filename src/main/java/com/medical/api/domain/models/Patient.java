package com.medical.api.domain.models;

import com.medical.api.domain.valueObject.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {

    private Long id = null;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private Address address;
}
