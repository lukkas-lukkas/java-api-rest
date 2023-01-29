package com.medical.api.application.doctor.dto;

import com.medical.api.application.shared.dto.AddressDto;
import com.medical.api.domain.enums.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorDto(

	@NotBlank
	String name,

	@NotBlank
	@Email
	String email,

	@NotBlank
	@Pattern(regexp = "\\d{4,6}")
	String crm,

	@NotNull
	Specialty specialty,

	@NotNull
	@Valid
	AddressDto address
) {
}
