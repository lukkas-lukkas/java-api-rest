package com.medical.api.application.createDoctor;

import com.medical.api.domain.dto.CreateDoctorDto;
import com.medical.api.domain.models.Doctor;
import com.medical.api.domain.valueObject.Address;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public CreateDoctorResponse create (CreateDoctorDto dto) {
        var doctor = new Doctor(
                null,
                dto.name(),
                dto.email(),
                dto.crm(),
                dto.specialty(),
                new Address(dto.address())
        );

        doctorRepository.save(doctor);

        return new CreateDoctorResponse(doctor);
    }
}
