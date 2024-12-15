package com.example.demo.model.dto.response.entity;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class UserResponse extends EntityResponse {
    private final String firstName;
    private final String lastName;
    private final String email;

    public UserResponse(Integer id, LocalDateTime createdAt, String firstName, String lastName, String email) {
        super(id, createdAt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
