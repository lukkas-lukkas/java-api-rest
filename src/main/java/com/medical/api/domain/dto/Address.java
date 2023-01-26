package com.medical.api.domain.dto;

public record Address (
	String street,
	String neighborhood,
	String zipcode,
	String city,
	String state,
	String complement
) {
	
}
