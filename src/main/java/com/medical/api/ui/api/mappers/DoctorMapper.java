package com.medical.api.ui.api.mappers;

import com.medical.api.application.doctor.DoctorDto;
import com.medical.api.domain.enums.Specialty;
import com.medical.api.domain.models.Doctor;
import com.medical.api.domain.valueObject.Address;
import com.medical.api.ui.api.requests.CreateDoctorRequest;
import com.medical.api.ui.api.requests.UpdateDoctorRequest;
import com.medical.api.ui.api.responses.DoctorResponse;
import org.springframework.stereotype.Component;

@Component("ApiDoctorMapper")
public class DoctorMapper {

    public DoctorDto toDto(CreateDoctorRequest request) {
        var address = new Address(
            request.address().street(),
            request.address().neighborhood(),
            request.address().zipcode(),
            request.address().city(),
            request.address().state(),
            request.address().complement()
        );

        return DoctorDto.builder()
            .name(request.name())
            .email(request.email())
            .crm(request.crm())
            .specialty(Specialty.ofString(request.specialty()))
            .address(address)
            .build();
    }

    public DoctorDto toDto(UpdateDoctorRequest request) {
        var builder = DoctorDto.builder();

        if (request.address() != null) {
            var address = new Address(
                    request.address().street(),
                    request.address().neighborhood(),
                    request.address().zipcode(),
                    request.address().city(),
                    request.address().state(),
                    request.address().complement()
            );
            builder.address(address);
        }

        if (request.specialty() != null) {
            builder.specialty(Specialty.ofString(request.specialty()));
        }

        builder
            .name(request.name())
            .email(request.email())
            .crm(request.crm());

        return builder.build();
    }

    public DoctorResponse toResponse(Doctor doctor) {
        return new DoctorResponse(
            doctor.getId(),
            doctor.getName(),
            doctor.getEmail(),
            doctor.getCrm(),
            doctor.getSpecialty().toString()
        );
    }
}
