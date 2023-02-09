package com.medical.api.application.patient;

import com.medical.api.domain.models.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

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

    Patient merge(Patient patient, PatientDto dto) {
        patient.setName(dto.getName() != null ? dto.getName() : patient.getName());
        patient.setEmail(dto.getEmail() != null ? dto.getEmail() : patient.getEmail());
        patient.setPhone(dto.getPhone() != null ? dto.getPhone() : patient.getPhone());
        patient.setCpf(dto.getCpf() != null ? dto.getCpf() : patient.getCpf());

        var newAddress = patient.getAddress();
        if (dto.getAddress() != null) {
            var dtoAddress = dto.getAddress();

            newAddress.setStreet(dtoAddress.getStreet() != null ? dtoAddress.getStreet() : newAddress.getStreet());
            newAddress.setNeighborhood(
                    dtoAddress.getNeighborhood() != null ?
                            dtoAddress.getNeighborhood()
                            : newAddress.getNeighborhood()
            );
            newAddress.setZipcode(
                    dtoAddress.getZipcode() != null ?
                            dtoAddress.getZipcode()
                            : newAddress.getZipcode()
            );
            newAddress.setCity(
                    dtoAddress.getCity() != null ?
                            dtoAddress.getCity()
                            : newAddress.getCity()
            );
            newAddress.setState(
                    dtoAddress.getState() != null ?
                            dtoAddress.getState()
                            : newAddress.getState()
            );
            newAddress.setComplement(
                    dtoAddress.getComplement() != null ?
                            dtoAddress.getComplement()
                            : newAddress.getComplement()
            );
        }
        patient.setAddress(newAddress);

        return patient;
    }
}
