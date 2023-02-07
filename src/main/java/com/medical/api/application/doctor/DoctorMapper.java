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

        var newAdress = doctor.getAddress();
        if (dto.getAddress() != null) {
            var dtoAddress = dto.getAddress();

            newAdress.setStreet(dtoAddress.getStreet() != null ? dtoAddress.getStreet() : newAdress.getStreet());
            newAdress.setNeighborhood(
                dtoAddress.getNeighborhood() != null ?
                    dtoAddress.getNeighborhood()
                    : newAdress.getNeighborhood()
            );
            newAdress.setZipcode(
                dtoAddress.getZipcode() != null ?
                    dtoAddress.getZipcode()
                    : newAdress.getZipcode()
            );
            newAdress.setCity(
                dtoAddress.getCity() != null ?
                    dtoAddress.getCity()
                    : newAdress.getCity()
            );
            newAdress.setState(
                dtoAddress.getState() != null ?
                    dtoAddress.getState()
                    : newAdress.getState()
            );
            newAdress.setComplement(
                dtoAddress.getComplement() != null ?
                    dtoAddress.getComplement()
                    : newAdress.getComplement()
            );
        }
        doctor.setAddress(newAdress);

        return doctor;
    }
}
