package com.medical.api.application.doctor;

import com.medical.api.application.doctor.dto.DoctorDto;
import com.medical.api.domain.models.Doctor;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor create (DoctorDto dto) {
        var doctor = dto.toDoctor();

        this.doctorRepository.save(doctor);

        return doctor;
    }
}
