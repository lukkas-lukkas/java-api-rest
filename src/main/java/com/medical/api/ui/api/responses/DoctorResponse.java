package com.medical.api.ui.api.responses;

public record DoctorResponse(
    String name,
    String email,
    String crm,
    String specialty
) {
}
