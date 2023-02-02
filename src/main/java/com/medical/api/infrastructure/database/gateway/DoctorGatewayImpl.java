package com.medical.api.infrastructure.database.gateway;

import com.medical.api.infrastructure.database.mapper.DoctorMapper;
import com.medical.api.infrastructure.database.repository.DoctorRepository;
import com.medical.api.domain.gateway.DoctorGateway;
import com.medical.api.domain.models.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorGatewayImpl implements DoctorGateway {

    private DoctorRepository repository;
    private DoctorMapper mapper;

    @Override
    public Doctor insert(Doctor doctor) {
        var doctorCreated = repository.save(mapper.toEntity(doctor));
        return mapper.toDomain(doctorCreated);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public Optional<Doctor> getById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Doctor> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public List<Doctor> getAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Doctor update(Doctor doctor) {
        var doctorUpdated = repository.save(mapper.toEntity(doctor));
        return mapper.toDomain(doctorUpdated);
    }
}
