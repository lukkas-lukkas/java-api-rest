package com.medical.api.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Specialty {

	ORTHOPEDICS("orthopedics"),
	CARDIOLOGY("cardiology"),
	GYNECOLOGY("gynecology"),
	DERMATOLOGY("dermatology");

	private final String value;

	public static Specialty ofString(String value) {
		return Specialty.valueOf(value.toUpperCase());
	}

	@Override
	public String toString() {
		return value;
	}
}
