package com.medical.api.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "patients")
@Entity(name = "Patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private AddressEntity address;
}
