package com.medical.api.application.patient.dto;

import com.medical.api.application.shared.dto.UpdateAddressDto;
import com.medical.api.domain.models.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record UpdatePatientDto(

	@Email
	String email,

	@Pattern(regexp = "\\d{10,11}")
	String phone,

	@Pattern(regexp = "\\d{11}")
	String cpf,

	@Valid
	UpdateAddressDto address,

	String name
) {
	public Patient update(Patient patient) {
		if (this.name != null) {
			patient.setName(this.name);
		}

		if (this.email != null) {
			patient.setEmail(this.email);
		}

		if (this.phone != null) {
			patient.setPhone(this.phone);
		}

		if (this.cpf != null) {
			patient.setCpf(this.cpf);
		}

		if (this.address != null) {
			var newAddress = this.address.updateAddress(patient.getAddress());
			patient.setAddress(newAddress);
		}

		return patient;
	}
}
