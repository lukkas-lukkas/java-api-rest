package com.medical.api.application.createDoctor;

import com.medical.api.domain.models.Doctor;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListDoctorService {

    @Autowired
    private DoctorRepository repository;
    public List<Doctor> get() {
        return repository.findAll();
    }
}
