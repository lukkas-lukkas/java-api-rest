package com.medical.api.ui.api.mappers;

import com.medical.api.application.doctor.DoctorDto;
import com.medical.api.domain.models.Doctor;
import com.medical.api.ui.api.requests.CreateDoctorRequest;
import com.medical.api.ui.api.requests.UpdateDoctorRequest;
import com.medical.api.ui.api.responses.DoctorResponse;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorMapper {

    DoctorDto toDto(CreateDoctorRequest request);

    DoctorDto toDto(UpdateDoctorRequest request);

    DoctorResponse toResponse(Doctor doctor);
}
