package com.medical.api.application.doctor;

import com.medical.api.domain.models.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toDomain(DoctorDto dto);

    Doctor merge(@MappingTarget Doctor doctor, DoctorDto dto);
}
