package com.medical.api.domain.models;

import com.medical.api.domain.enums.Specialty;
import com.medical.api.domain.valueObject.Address;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;
}
