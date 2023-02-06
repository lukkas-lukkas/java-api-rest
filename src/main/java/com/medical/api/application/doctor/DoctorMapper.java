package com.medical.api.application.doctor;

import com.medical.api.domain.models.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

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

    Doctor merge(Doctor doctor, DoctorDto dto) {
        doctor.setName(dto.getName());
        doctor.setEmail(dto.getEmail());
        doctor.setCrm(dto.getCrm());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setAddress(dto.getAddress());

        return doctor;
    }
}
