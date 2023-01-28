package com.medical.api.application.doctor;

import com.medical.api.infrastructure.persistence.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteDoctorService {

    @Autowired
    private DoctorRepository repository;

    public void delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }
    }
}
