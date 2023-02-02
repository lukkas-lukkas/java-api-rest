package com.medical.api.domain.models;

import com.medical.api.infrastructure.database.entity.AddressEntity;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;

    private AddressEntity address;
}
