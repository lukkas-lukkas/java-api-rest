package com.medical.api.ui.api.mappers;

import com.medical.api.application.patient.PatientDto;
import com.medical.api.domain.models.Patient;
import com.medical.api.ui.api.requests.CreatePatientRequest;
import com.medical.api.ui.api.requests.UpdatePatientRequest;
import com.medical.api.ui.api.responses.PatientResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PatientMapper {

    PatientDto toDto(CreatePatientRequest request);

    PatientDto toDto(UpdatePatientRequest request);

    PatientResponse toResponse(Patient patient);
}
