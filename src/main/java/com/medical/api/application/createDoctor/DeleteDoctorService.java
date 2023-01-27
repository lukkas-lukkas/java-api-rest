package com.medical.api.application.createDoctor;

import com.medical.api.domain.models.Doctor;
import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteDoctorService {

    @Autowired
    private DoctorRepository repository;
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
