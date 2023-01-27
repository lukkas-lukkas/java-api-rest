package com.medical.api.application.createDoctor;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Doctor;
import com.medical.api.domain.valueObject.Address;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateDoctorService {

    @Autowired
    private DoctorRepository repository;
    public Doctor update(DoctorDto dto, Long id) throws DataNotFoundException {
        Optional<Doctor> optional = repository.findById(id);

        if (optional.isEmpty()) {
            throw new DataNotFoundException();
        }

        var doctor = optional.get();

        doctor.setName(dto.name());
        doctor.setEmail(dto.email());
        doctor.setCrm(dto.crm());
        doctor.setSpecialty(dto.specialty());
        doctor.setAddress(new Address(dto.address()));

        return doctor;
    }
}
