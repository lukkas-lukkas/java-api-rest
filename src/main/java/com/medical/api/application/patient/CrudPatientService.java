package com.medical.api.application.patient;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.gateway.PatientGateway;
import com.medical.api.domain.models.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrudPatientService {

    private PatientGateway gateway;
    private PatientMapper mapper;

    public Patient create(PatientDto dto) {
        return gateway.insert(mapper.toDomain(dto));
    }

    public void delete(Long id) {
        gateway.delete(id);
    }

    public Patient getById(Long id) throws DataNotFoundException {
        return gateway.getById(id).orElseThrow(DataNotFoundException::new);
    }

    public Page<Patient> getAll(Pageable pageable) {
        return gateway.getAll(pageable);
    }

    public Patient update(Long id, PatientDto dto) throws DataNotFoundException {
        var patient = gateway.getById(id).orElseThrow(DataNotFoundException::new);

        mapper.merge(patient, dto);
        gateway.update(patient);

        return patient;
    }
}
