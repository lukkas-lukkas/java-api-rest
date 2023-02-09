package com.medical.api.application.patient;

import com.medical.api.domain.valueObject.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientDto {
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private Address address;
}
