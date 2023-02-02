package com.medical.api.domain.models;

import com.medical.api.domain.enums.Specialty;
import com.medical.api.infrastructure.database.entity.AddressEntity;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private Long id;
    private String name;
    private String email;
    private String crm;

    private Specialty specialty;

    private AddressEntity address;
}
