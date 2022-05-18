package com.example.blog.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

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
