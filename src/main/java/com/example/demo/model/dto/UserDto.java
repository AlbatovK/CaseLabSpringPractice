package com.example.demo.model.dto;

import com.example.demo.model.data.User;

public record UserDto(String name, String description) {

    public static UserDto createFromUser(User user) {
        return new UserDto(
                user.name(),
                user.description()
        );
    }

}
