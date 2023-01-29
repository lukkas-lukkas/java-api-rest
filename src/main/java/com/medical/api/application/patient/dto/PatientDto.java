package com.medical.api.application.patient.dto;

import com.medical.api.application.shared.dto.AddressDto;
import com.medical.api.domain.models.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientDto(

	@NotBlank
	String name,

	@NotBlank
	@Email
	String email,

	@NotBlank
	@Pattern(regexp = "\\d{10,11}")
	String phone,

	@NotNull
	@Pattern(regexp = "\\d{11}")
	String cpf,

	@NotNull
	@Valid
	AddressDto address
) {
	public Patient toPatient() {
		return new Patient(
			null,
			this.name(),
			this.email(),
			this.phone(),
			this.cpf(),
			this.address.toAddress()
		);
	}
}
