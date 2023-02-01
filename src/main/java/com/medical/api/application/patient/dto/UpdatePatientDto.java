package com.medical.api.application.patient.dto;

import com.medical.api.application.shared.dto.UpdateAddressDto;
import com.medical.api.domain.dto.UpdateModelDto;
import com.medical.api.domain.models.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdatePatientDto implements UpdateModelDto<Patient> {

	String name;

	@Email
	private String email;

	@Pattern(regexp = "\\d{10,11}")
	private String phone;

	@Pattern(regexp = "\\d{11}")
	private String cpf;

	@Valid
	private UpdateAddressDto address;

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
