package com.example.demo.view.controller.impl;

import com.example.demo.model.dto.request.UserRequest;
import com.example.demo.model.dto.response.entity.UserResponse;
import com.example.demo.model.dto.response.exception.NotFoundException;
import com.example.demo.model.dto.response.message.DeletedResponse;
import com.example.demo.model.service.UserService;
import com.example.demo.view.controller.UserController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    public UserControllerImpl(UserService service) {
        this.service = service;
    }

    private final UserService service;

    @Override
    @GetMapping("/admin")
    public void getAdmin() throws NotFoundException {
        service.getAdmin();
    }

    @GetMapping("/")
    @Override
    public List<UserResponse> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    @Override
    public UserResponse getById(@PathVariable Integer id) throws NotFoundException {
        return service.getById(id);
    }

    @Override
    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Integer id, @RequestBody UserRequest request) throws NotFoundException {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Override
    public DeletedResponse delete(@PathVariable Integer id) throws NotFoundException {
        service.delete(id);
        return new DeletedResponse();
    }
}
