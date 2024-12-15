package com.example.demo.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record UserRequest(
        @Length(min = 3, max = 12) @NotNull
        String firstName,
        @Length(min = 3, max = 12) @NotNull
        String lastName,
        @Email @NotNull
        String email
) {}
