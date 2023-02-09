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
        doctor.setName(dto.getName() != null ? dto.getName() : doctor.getName());
        doctor.setEmail(dto.getEmail() != null ? dto.getEmail() : doctor.getEmail());
        doctor.setCrm(dto.getCrm() != null ? dto.getCrm() : doctor.getCrm());
        doctor.setSpecialty(dto.getSpecialty() != null ? dto.getSpecialty() : doctor.getSpecialty());

        var newAddress = doctor.getAddress();
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
        doctor.setAddress(newAddress);

        return doctor;
    }
}
