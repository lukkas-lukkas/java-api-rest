package com.medical.api.application.doctor;

import com.medical.api.application.doctor.dto.DoctorDto;
import com.medical.api.application.doctor.dto.UpdateDoctorDto;
import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Doctor;
import com.medical.api.domain.valueObject.Address;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor update(DoctorDto dto, Long id) throws DataNotFoundException {
        var doctor = repository.findById(id)
                .orElseThrow(DataNotFoundException::new);

        doctor.setName(dto.name());
        doctor.setEmail(dto.email());
        doctor.setCrm(dto.crm());
        doctor.setSpecialty(dto.specialty());
        doctor.setAddress(new Address(dto.address()));

        return doctor;
    }

    public Doctor update(UpdateDoctorDto dto, Long id) throws DataNotFoundException {
        var doctor = repository.findById(id)
                .orElseThrow(DataNotFoundException::new);

        return dto.updateDoctor(doctor);
    }
}
