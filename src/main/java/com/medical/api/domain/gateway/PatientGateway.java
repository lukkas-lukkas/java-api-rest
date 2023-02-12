package com.medical.api.domain.gateway;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PatientGateway {

    Patient insert(Patient patient);

    void delete(Long id);

    Optional<Patient> getById(Long id);

    Page<Patient> getAll(Pageable pageable);

    List<Patient> getAll();

    void update(Patient patient) throws DataNotFoundException;
}
