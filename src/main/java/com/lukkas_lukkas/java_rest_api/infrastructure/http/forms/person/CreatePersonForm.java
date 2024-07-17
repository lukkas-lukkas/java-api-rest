package com.lukkas_lukkas.java_rest_api.infrastructure.http.forms.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreatePersonForm {

    @NotNull
    @Size(min=2, max=255)
    public final String name;

    @NotNull
    @Email
    public final String email;

    @NotNull
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    public final String password;


    public CreatePersonForm(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}