package com.medical.api.application.patient.dto;

import com.medical.api.application.shared.dto.AddressDto;
import com.medical.api.domain.dto.ModelDto;
import com.medical.api.domain.models.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PatientDto implements ModelDto<Patient> {

	@NotBlank
	private String name;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Pattern(regexp = "\\d{10,11}")
	private String phone;

	@NotBlank
	@Pattern(regexp = "\\d{11}")
	private String cpf;

	@NotNull
	@Valid
	private AddressDto address;

	public Patient toModel() {
		return new Patient(
			null,
			this.name,
			this.email,
			this.phone,
			this.cpf,
			this.address.toAddress()
		);
	}

	public Patient update(Patient patient) {
		patient.setName(this.name);
		patient.setEmail(this.email);
		patient.setPhone(this.phone);
		patient.setCpf(this.cpf);
		patient.setAddress(this.address.toAddress());

		return patient;
	}
}
