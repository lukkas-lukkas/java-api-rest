package com.medical.api.ui.api.responses;

public record DoctorResponse(

    Long id,
    String name,
    String email,
    String crm,
    String specialty
) {
}
