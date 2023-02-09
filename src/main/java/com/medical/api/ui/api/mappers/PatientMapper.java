package com.medical.api.ui.api.mappers;

import com.medical.api.application.patient.PatientDto;
import com.medical.api.domain.models.Patient;
import com.medical.api.domain.valueObject.Address;
import com.medical.api.ui.api.requests.CreatePatientRequest;
import com.medical.api.ui.api.requests.UpdatePatientRequest;
import com.medical.api.ui.api.responses.PatientResponse;
import org.springframework.stereotype.Component;

@Component("ApiPatientMapper")
public class PatientMapper {

    public PatientDto toDto(CreatePatientRequest request) {
        var address = new Address(
            request.address().street(),
            request.address().neighborhood(),
            request.address().zipcode(),
            request.address().city(),
            request.address().state(),
            request.address().complement()
        );

        return PatientDto.builder()
            .name(request.name())
            .email(request.email())
            .phone(request.phone())
            .cpf(request.cpf())
            .address(address)
            .build();
    }

    public PatientDto toDto(UpdatePatientRequest request) {
        var builder = PatientDto.builder();

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

        builder
            .name(request.name())
            .email(request.email())
            .phone(request.phone())
            .cpf(request.cpf());

        return builder.build();
    }

    public PatientResponse toResponse(Patient patient) {
        return new PatientResponse(
            patient.getId(),
            patient.getName(),
            patient.getEmail(),
            patient.getPhone(),
            patient.getCpf()
        );
    }
}
