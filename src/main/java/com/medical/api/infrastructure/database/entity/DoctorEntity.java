package com.medical.api.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "doctors")
@Entity(name = "Doctor")
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    private String specialty;

    @Embedded
    private AddressEntity address;
}
