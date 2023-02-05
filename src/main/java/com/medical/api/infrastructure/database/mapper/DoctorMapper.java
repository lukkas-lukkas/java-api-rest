package com.medical.api.infrastructure.database.mapper;

import com.medical.api.domain.models.Doctor;
import com.medical.api.infrastructure.database.entity.DoctorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toDomain(DoctorEntity doctorEntity);

    DoctorEntity toEntity(Doctor doctor);
}
