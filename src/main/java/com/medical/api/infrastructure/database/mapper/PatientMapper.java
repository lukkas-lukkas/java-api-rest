package com.medical.api.infrastructure.database.mapper;

import com.medical.api.domain.models.Patient;
import com.medical.api.domain.valueObject.Address;
import com.medical.api.infrastructure.database.entity.AddressEntity;
import com.medical.api.infrastructure.database.entity.PatientEntity;
import org.springframework.stereotype.Component;

@Component("DatabasePatientMapper")
public class PatientMapper {

    public Patient toDomain(PatientEntity patientEntity) {
        return new Patient(
            patientEntity.getId(),
            patientEntity.getName(),
            patientEntity.getEmail(),
            patientEntity.getPhone(),
            patientEntity.getCpf(),
            new Address(
                patientEntity.getAddress().getStreet(),
                patientEntity.getAddress().getNeighborhood(),
                patientEntity.getAddress().getZipcode(),
                patientEntity.getAddress().getCity(),
                patientEntity.getAddress().getState(),
                patientEntity.getAddress().getComplement()
            )
        );
    }

    public PatientEntity toEntity(Patient doctor) {
        var address = AddressEntity.builder()
            .street(doctor.getAddress().getStreet())
            .neighborhood(doctor.getAddress().getNeighborhood())
            .zipcode(doctor.getAddress().getZipcode())
            .city(doctor.getAddress().getCity())
            .state(doctor.getAddress().getState())
            .complement(doctor.getAddress().getComplement())
            .build();

        return PatientEntity.builder()
            .id(doctor.getId())
            .name(doctor.getName())
            .email(doctor.getEmail())
            .phone(doctor.getPhone())
            .cpf(doctor.getCpf())
            .address(address)
            .build();
    }
}
