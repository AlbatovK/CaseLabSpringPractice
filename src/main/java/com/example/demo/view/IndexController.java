package com.example.demo.view;

import com.example.demo.model.data.Author;
import com.example.demo.model.data.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.repository.AuthorRepository;
import com.example.demo.model.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class IndexController {

    private final AuthorRepository authorRepository;

    public IndexController(
            AuthorRepository repository
    ) {
        this.authorRepository = repository;
    }

    @GetMapping("/")
    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Author> getAuthorsByName(@PathVariable String name) {
        return authorRepository.findAuthorByNameStartingWith(name);
    }

    @PostMapping("/")
    public void saveAuthor(@RequestBody Author author) {
        authorRepository.save(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorRepository.deleteById(id);
    }


}
