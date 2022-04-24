package com.meli.blog.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class EntradaRequestDTO {
    private Number id;
    private String tituloEntrada;
    private String autor;
    private String fechaPublicacion;

    public EntradaRequestDTO(Number id, String tituloEntrada, String autor, String fechaPublicacion) {
        this.id = id;
        this.tituloEntrada = tituloEntrada;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
