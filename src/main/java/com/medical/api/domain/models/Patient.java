package com.medical.api.domain.models;

import com.medical.api.domain.valueObject.Address;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "patients")
@Entity(name = "Patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private Address address;
}
