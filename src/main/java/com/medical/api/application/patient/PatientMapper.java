package com.medical.api.application.patient;

import com.medical.api.domain.models.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toDomain(PatientDto dto);

    Patient merge(@MappingTarget Patient patient, PatientDto dto);
}
