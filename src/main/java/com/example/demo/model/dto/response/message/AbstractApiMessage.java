package com.example.demo.model.dto.response.message;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public abstract class AbstractApiMessage {

    protected final String message;

    protected final HttpStatus status = HttpStatus.OK;

    public ResponseEntity<AbstractApiMessage> asResponse() {
        return ResponseEntity.status(status).body(this);
    }
}
