package com.medical.api.ui.api.facades;

import com.medical.api.application.patient.CrudPatientService;
import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.ui.api.mappers.PatientMapper;
import com.medical.api.ui.api.requests.CreatePatientRequest;
import com.medical.api.ui.api.requests.UpdatePatientRequest;
import com.medical.api.ui.api.responses.PatientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class PatientFacade {

    private CrudPatientService service;
    private PatientMapper mapper;

    public PatientResponse create(CreatePatientRequest request) {
        var doctor = service.create(mapper.toDto(request));
        return mapper.toResponse(doctor);
    }

    public Page<PatientResponse> getAll(Pageable pageable) {
        return service.getAll(pageable).map(mapper::toResponse);
    }

    public PatientResponse getById(Long id) throws DataNotFoundException {
        var doctor = service.getById(id);
        return mapper.toResponse(doctor);
    }

    public PatientResponse update(Long id, UpdatePatientRequest request) throws DataNotFoundException {
        var patient = service.update(id, mapper.toDto(request));
        return mapper.toResponse(patient);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
