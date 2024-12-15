package com.example.demo.view.controller;

import com.example.demo.model.dto.request.UserRequest;
import com.example.demo.model.dto.response.message.DeletedResponse;
import com.example.demo.model.dto.response.exception.NotFoundException;
import com.example.demo.model.dto.response.entity.UserResponse;

import java.util.List;

public interface UserController {
    List<UserResponse> list();

    UserResponse getById(Integer id) throws NotFoundException;

    UserResponse create(UserRequest request);

    UserResponse update(Integer id, UserRequest request) throws NotFoundException;

    DeletedResponse delete(Integer id) throws NotFoundException;
}
