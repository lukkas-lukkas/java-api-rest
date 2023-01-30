package com.medical.api.application.doctor.dto;

import com.medical.api.application.shared.dto.AddressDto;
import com.medical.api.domain.dto.ModelDto;
import com.medical.api.domain.enums.Specialty;
import com.medical.api.domain.models.Doctor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoctorDto implements ModelDto<Doctor> {

	@NotBlank
	private String name;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Pattern(regexp = "\\d{4,6}")
	private String crm;

	@NotNull
	private Specialty specialty;

	@NotNull
	@Valid
	private AddressDto address;

	public Doctor toModel() {
		return new Doctor(
			null,
			this.name,
			this.email,
			this.crm,
			this.specialty,
			this.address.toAddress()
		);
	}

	public Doctor update(Doctor doctor) {
		doctor.setName(this.name);
		doctor.setEmail(this.email);
		doctor.setCrm(this.crm);
		doctor.setSpecialty(this.specialty);
		doctor.setAddress(this.address.toAddress());

		return doctor;
	}
}
