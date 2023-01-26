package com.medical.api.application.createDoctor;

import com.medical.api.domain.enums.Specialty;
import com.medical.api.domain.models.Doctor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateDoctorResponse {

    private Long id;
    private String name;
    private String email;
    private String crm;
    private Specialty specialty;

    public CreateDoctorResponse(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.email = doctor.getEmail();
        this.crm = doctor.getCrm();
        this.specialty = doctor.getSpecialty();
    }
}
