package com.medical.api.infrastructure.database.mapper;

import com.medical.api.domain.models.Patient;
import com.medical.api.infrastructure.database.entity.PatientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toDomain(PatientEntity patientEntity);

    PatientEntity toEntity(Patient patient);
}
