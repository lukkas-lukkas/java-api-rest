package com.medical.api.application.doctor;

import com.medical.api.application.AddressMerger;
import com.medical.api.domain.models.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper implements AddressMerger {

    Doctor toDomain(DoctorDto dto) {
        return new Doctor(
            null,
            dto.getName(),
            dto.getEmail(),
            dto.getCrm(),
            dto.getSpecialty(),
            dto.getAddress()
        );
    }

    void merge(Doctor doctor, DoctorDto dto) {
        doctor.setName(dto.getName() != null ? dto.getName() : doctor.getName());
        doctor.setEmail(dto.getEmail() != null ? dto.getEmail() : doctor.getEmail());
        doctor.setCrm(dto.getCrm() != null ? dto.getCrm() : doctor.getCrm());
        doctor.setSpecialty(dto.getSpecialty() != null ? dto.getSpecialty() : doctor.getSpecialty());

        if (dto.getAddress() != null) {
            merge(doctor.getAddress(), dto.getAddress());
        }
    }
}
