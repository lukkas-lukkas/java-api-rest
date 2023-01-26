package com.medical.api.domain.dto;

import com.medical.api.domain.enums.Specialty;

public record CreateDoctorDto (
	String name,
	String email,
	String crm,
	Specialty specialty,
	Address address
) {
	
}
