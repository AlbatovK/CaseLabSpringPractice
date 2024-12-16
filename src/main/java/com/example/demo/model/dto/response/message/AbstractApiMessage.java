package com.example.demo.model.dto.response.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public abstract class AbstractApiMessage {

    protected final String message;

    protected final HttpStatus status = HttpStatus.OK;

    public ResponseEntity<AbstractApiMessage> asResponse() {
        return ResponseEntity.status(status).body(this);
    }
}
