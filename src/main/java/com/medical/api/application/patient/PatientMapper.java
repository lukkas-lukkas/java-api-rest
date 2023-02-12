package com.medical.api.application.patient;

import com.medical.api.application.AddressMerger;
import com.medical.api.domain.models.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper implements AddressMerger {

    Patient toDomain(PatientDto dto) {
        return new Patient(
                null,
                dto.getName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getCpf(),
                dto.getAddress()
        );
    }

    void merge(Patient patient, PatientDto dto) {
        patient.setName(dto.getName() != null ? dto.getName() : patient.getName());
        patient.setEmail(dto.getEmail() != null ? dto.getEmail() : patient.getEmail());
        patient.setPhone(dto.getPhone() != null ? dto.getPhone() : patient.getPhone());
        patient.setCpf(dto.getCpf() != null ? dto.getCpf() : patient.getCpf());

        if (dto.getAddress() != null) {
            merge(patient.getAddress(), dto.getAddress());
        }
    }
}
