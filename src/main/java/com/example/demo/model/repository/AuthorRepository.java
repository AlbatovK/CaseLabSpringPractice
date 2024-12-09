package com.example.demo.model.repository;

import com.example.demo.model.data.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findAuthorByNameStartingWith(String name);
}
