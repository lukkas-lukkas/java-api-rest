package com.medical.api.application.doctor;

import com.medical.api.domain.models.Doctor;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListDoctorService {

    @Autowired
    private DoctorRepository repository;

    public Page<Doctor> get(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
