package com.Spring.LinkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LinkDTO {

    private String url;
    private Integer contadorRedirecciones;
    private boolean activo;

}
