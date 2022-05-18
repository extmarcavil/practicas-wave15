package com.Spring.LinkTracker.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class ErrorDTO {
    public ErrorDTO(String mensaje, HttpStatus status) {
        this.mensaje = mensaje;
        this.status = status;
    }

    private String mensaje;
    private HttpStatus status;
}