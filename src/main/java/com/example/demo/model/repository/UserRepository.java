package com.example.demo.model.repository;

import com.example.demo.model.data.User;

import java.util.List;

public interface UserRepository {
    List<User> listUsers();

    User createUser(User user);

    User findUserById(int id);
}
