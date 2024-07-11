package com.lukkas_lukkas.java_rest_api.infrastructure.http.forms.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UpdatePersonForm {

    @Size(min=2, max=255)
    public final String name;

    @Email
    public final String email;

    public UpdatePersonForm(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
