package com.medical.api.infrastructure.database.mapper;

import com.medical.api.domain.models.Patient;
import com.medical.api.infrastructure.database.entity.PatientEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PatientMapper {
    Patient toDomain(PatientEntity doctorEntity);

    PatientEntity toEntity(Patient doctor);
}
