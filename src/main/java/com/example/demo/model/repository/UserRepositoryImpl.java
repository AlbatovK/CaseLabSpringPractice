package com.example.demo.model.repository;

import com.example.demo.model.data.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>(List.of(
            new User("John", "213", "descr"),
            new User("Mary", "593", "descr"),
            new User("Jack", "51351", "descr")
    ));

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findUserById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> listUsers() {
        return users;
    }
}
