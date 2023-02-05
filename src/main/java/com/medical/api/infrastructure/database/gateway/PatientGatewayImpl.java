package com.medical.api.infrastructure.database.gateway;

import com.medical.api.domain.exceptions.DataNotFoundException;
import com.medical.api.domain.gateway.PatientGateway;
import com.medical.api.domain.models.Patient;
import com.medical.api.infrastructure.database.mapper.PatientMapper;
import com.medical.api.infrastructure.database.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PatientGatewayImpl implements PatientGateway {

    private PatientRepository repository;
    private PatientMapper mapper;

    @Override
    public Patient insert(Patient patient) {
        var entity = repository.save(mapper.toEntity(patient));
        return mapper.toDomain(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Patient> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<Patient> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public List<Patient> getAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void update(Patient patient) throws DataNotFoundException {
        if (!repository.existsById(patient.getId())) {
            throw new DataNotFoundException();
        }

        repository.save(mapper.toEntity(patient));
    }
}
