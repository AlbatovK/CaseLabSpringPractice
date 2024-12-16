package com.example.demo.model.service;

import com.example.demo.model.database.entity.User;
import com.example.demo.model.dto.request.UserRequest;
import com.example.demo.model.dto.response.exception.AlreadyExistsException;
import com.example.demo.model.dto.response.exception.NotFoundException;
import com.example.demo.model.dto.response.entity.UserResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface UserService {
    List<UserResponse> list();

    UserResponse getById(Integer id) throws NotFoundException;

    void create(User user) throws AlreadyExistsException;

    UserResponse update(Integer id, @Valid UserRequest request) throws NotFoundException;

    void delete(Integer id) throws NotFoundException;

    void getAdmin() throws NotFoundException;


}
