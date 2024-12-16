package com.example.demo.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record SignUpRequest(
        @Email @NotNull
        String email,

        @Length(min = 5, max = 30) @NotNull
        String password,

        @Length(min = 3, max = 12) @NotNull
        String firstName,
        @Length(min = 3, max = 12) @NotNull
        String lastName
) {
}
