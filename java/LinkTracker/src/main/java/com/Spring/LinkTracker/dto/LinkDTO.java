package com.Spring.LinkTracker.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {

    private String url;
    private Integer contadorRedirecciones;
    private boolean activo;

    public LinkDTO(String url, Integer contadorRedirecciones, boolean activo) {
        this.url = url;
        this.contadorRedirecciones = contadorRedirecciones;
        this.activo = activo;
    }
}
