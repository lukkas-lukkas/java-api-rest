package com.medical.api.domain.gateway;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DoctorGateway {

    Doctor insert(Doctor doctor);

    void delete(Long id);

    Optional<Doctor> getById(Long id);

    Page<Doctor> getAll(Pageable pageable);

    List<Doctor> getAll();

    void update(Doctor doctor) throws DataNotFoundException;
}
