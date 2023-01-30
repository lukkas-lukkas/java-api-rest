package com.medical.api.application.doctor.dto;

import com.medical.api.application.shared.dto.UpdateAddressDto;
import com.medical.api.domain.dto.UpdateModelDto;
import com.medical.api.domain.enums.Specialty;
import com.medical.api.domain.models.Doctor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateDoctorDto implements UpdateModelDto<Doctor> {

	@Email
	private String email;

	@Pattern(regexp = "\\d{4,6}")
	private String crm;

	@Valid
	private UpdateAddressDto address;

	String name;
	private Specialty specialty;

	public Doctor update(Doctor doctor) {
		if (this.name != null) {
			doctor.setName(this.name);
		}

		if (this.email != null) {
			doctor.setEmail(this.email);
		}

		if (this.crm != null) {
			doctor.setCrm(this.crm);
		}

		if (this.specialty != null) {
			doctor.setSpecialty(this.specialty);
		}

		if (this.address != null) {
			var newAddress = this.address.updateAddress(doctor.getAddress());
			doctor.setAddress(newAddress);
		}

		return doctor;
	}
}
