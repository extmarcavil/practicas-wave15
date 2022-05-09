package com.sprint1.be_java_hisp_w15_g4.dto.response;

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
