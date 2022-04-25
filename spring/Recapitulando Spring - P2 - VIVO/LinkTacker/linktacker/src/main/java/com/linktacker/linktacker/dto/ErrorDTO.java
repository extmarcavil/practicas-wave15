package com.linktacker.linktacker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private boolean estatus;
    private String mensaje;

    public ErrorDTO() {

    }

    public ErrorDTO(boolean estatus, String mensaje) {
        this.estatus = estatus;
        this.mensaje = mensaje;
    }
}