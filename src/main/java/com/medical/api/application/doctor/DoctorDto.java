package com.medical.api.application.doctor;

import com.medical.api.domain.enums.Specialty;
import com.medical.api.domain.valueObject.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorDto {

    private String name;
    private String email;
    private String crm;
    private Specialty specialty;
    private Address address;
}
