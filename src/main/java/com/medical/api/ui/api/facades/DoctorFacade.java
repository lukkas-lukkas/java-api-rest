package com.medical.api.ui.api.facades;

import com.medical.api.application.doctor.CrudDoctorService;
import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.ui.api.mappers.DoctorMapper;
import com.medical.api.ui.api.requests.CreateDoctorRequest;
import com.medical.api.ui.api.requests.UpdateDoctorRequest;
import com.medical.api.ui.api.responses.DoctorResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DoctorFacade {

    private CrudDoctorService service;
    private DoctorMapper mapper;

    public DoctorResponse create(CreateDoctorRequest request) {
        var doctor = service.create(mapper.toDto(request));
        return mapper.toResponse(doctor);
    }

    public Page<DoctorResponse> getAll(Pageable pageable) {
        return service.getAll(pageable).map(mapper::toResponse);
    }

    public DoctorResponse getById(Long id) throws DataNotFoundException {
        var doctor = service.getById(id);
        return mapper.toResponse(doctor);
    }

    public DoctorResponse update(Long id, UpdateDoctorRequest request) throws DataNotFoundException {
        var doctor = service.update(id, mapper.toDto(request));
        return mapper.toResponse(doctor);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
