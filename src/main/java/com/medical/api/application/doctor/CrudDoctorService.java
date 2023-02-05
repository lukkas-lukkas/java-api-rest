package com.medical.api.application.doctor;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.gateway.DoctorGateway;
import com.medical.api.domain.models.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class CrudDoctorService {

    private DoctorGateway gateway;
    private DoctorMapper mapper;

    public Doctor create(DoctorDto dto) {
        return gateway.insert(mapper.toDomain(dto));
    }

    public void delete(Long id) {
        gateway.delete(id);
    }

    public Doctor getById(Long id) throws DataNotFoundException {
        return gateway.getById(id).orElseThrow(DataNotFoundException::new);
    }

    public Page<Doctor> getAll(Pageable pageable) {
        return gateway.getAll(pageable);
    }

    public Doctor update(Long id, DoctorDto dto) throws DataNotFoundException {
        var doctor = gateway.getById(id).orElseThrow(DataNotFoundException::new);

        gateway.update(mapper.merge(doctor, dto));

        return doctor;
    }
}
