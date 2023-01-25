package com.medical.api.domain.valueObject;

public record Address (
	String street,
	String neighborhood,
	String zipCode,
	String city,
	String state,
	String complement
) {
	
}
