package com.medical.api.application.doctor;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Doctor;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetDoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor getById(Long id) throws DataNotFoundException {
        return repository.findById(id)
                .orElseThrow(DataNotFoundException::new);
    }
}
