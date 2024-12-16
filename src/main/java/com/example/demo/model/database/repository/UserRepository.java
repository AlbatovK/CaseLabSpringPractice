package com.example.demo.model.database.repository;

import com.example.demo.model.database.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User> {
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
