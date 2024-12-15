package com.example.demo.view.resolver;

import com.example.demo.model.dto.response.exception.AbstractApiException;
import com.example.demo.model.dto.response.exception.ValidationErrorException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(AbstractApiException.class)
    public ResponseEntity<?> handle(AbstractApiException cause, WebRequest request) {
        return cause.asResponse();
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handle(ConstraintViolationException cause, WebRequest request) {
        return new ValidationErrorException(
                cause.getConstraintViolations().stream()
                        .map(v -> new ValidationErrorException.Violation(
                                v.getPropertyPath().toString(),
                                v.getMessage())
                        )
                        .collect(Collectors.toList())
        ).asResponse();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handle(MethodArgumentNotValidException cause, WebRequest request) {
        return new ValidationErrorException(
                cause.getBindingResult().getFieldErrors().stream()
                        .map(v -> new ValidationErrorException.Violation(
                                v.getField(),
                                v.getDefaultMessage())
                        )
                        .collect(Collectors.toList())
        ).asResponse();
    }
}
