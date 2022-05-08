package com.social.media.sprgbt.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ExceptionResponse {

    /**
     * Atributos
     */
    private LocalDateTime fecha;
    private String mensaje;
    private String detalle;
}
