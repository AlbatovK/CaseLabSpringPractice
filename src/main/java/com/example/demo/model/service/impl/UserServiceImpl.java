package com.example.demo.model.service.impl;


import com.example.demo.model.database.User;
import com.example.demo.model.database.repository.UserRepository;
import com.example.demo.model.dto.request.UserRequest;
import com.example.demo.model.dto.response.exception.NotFoundException;
import com.example.demo.model.dto.response.entity.UserResponse;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<UserResponse> list() {
        return mapper.asListResponse(
                repository.findAll()
        );
    }

    @Override
    public UserResponse getById(Integer id) throws NotFoundException {
        User user = repository.findEntityById(id);
        if (user == null)
            throw new NotFoundException();
        return mapper.asResponse(user);
    }

    @Transactional
    @Modifying
    @Override
    public UserResponse create(@Valid UserRequest request) {
        User user = mapper.asEntity(request);
        user = repository.save(user);

        return mapper.asResponse(user);
    }

    @Transactional
    @Modifying
    @Override
    public UserResponse update(Integer id, @Valid UserRequest request) throws NotFoundException {
        User user = repository.findEntityById(id);
        if (user == null)
            throw new NotFoundException();
        user = mapper.update(user, request);
        return mapper.asResponse(user);
    }

    @Transactional
    @Modifying
    @Override
    public void delete(Integer id) throws NotFoundException {
        User user = repository.findEntityById(id);
        if (user == null)
            throw new NotFoundException();
        repository.delete(user);
    }
}
