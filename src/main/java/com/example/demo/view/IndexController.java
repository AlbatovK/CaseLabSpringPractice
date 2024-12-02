package com.example.demo.view;

import com.example.demo.model.data.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    public IndexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @GetMapping("/")
    public List<UserDto> listUsers() {
        return userRepository.listUsers().stream().map((UserDto::createFromUser)).toList();
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable int id) {
        return UserDto.createFromUser(userRepository.findUserById(id));
    }


    @PostMapping("/")
    public UserDto createUser(User user) {
        return UserDto.createFromUser(this.userRepository.createUser(user));
    }


    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity handleException(IndexOutOfBoundsException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getCause());
    }

}
