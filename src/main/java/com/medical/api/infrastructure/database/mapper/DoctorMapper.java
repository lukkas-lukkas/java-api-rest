package com.medical.api.infrastructure.database.mapper;

import com.medical.api.domain.enums.Specialty;
import com.medical.api.domain.models.Doctor;
import com.medical.api.domain.valueObject.Address;
import com.medical.api.infrastructure.database.entity.AddressEntity;
import com.medical.api.infrastructure.database.entity.DoctorEntity;
import org.springframework.stereotype.Component;

@Component("DatabaseDoctorMapper")
public class DoctorMapper {

    public Doctor toDomain(DoctorEntity doctorEntity) {
        return new Doctor(
            doctorEntity.getId(),
            doctorEntity.getName(),
            doctorEntity.getEmail(),
            doctorEntity.getCrm(),
            Specialty.ofString(doctorEntity.getSpecialty()),
            new Address(
                doctorEntity.getAddress().getStreet(),
                doctorEntity.getAddress().getNeighborhood(),
                doctorEntity.getAddress().getZipcode(),
                doctorEntity.getAddress().getCity(),
                doctorEntity.getAddress().getState(),
                doctorEntity.getAddress().getComplement()
            )
        );
    }

    public DoctorEntity toEntity(Doctor doctor) {
        var address = AddressEntity.builder()
                .street(doctor.getAddress().getStreet())
                .neighborhood(doctor.getAddress().getNeighborhood())
                .zipcode(doctor.getAddress().getZipcode())
                .city(doctor.getAddress().getCity())
                .state(doctor.getAddress().getState())
                .complement(doctor.getAddress().getComplement())
                .build();

        return DoctorEntity.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .crm(doctor.getCrm())
                .specialty(doctor.getSpecialty().toString())
                .address(address)
                .build();
    }
}
