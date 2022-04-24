package com.meli.blog.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EntradaResponseFullDTO {
    private Integer id;
    private String tituloEntrada;
    private String autor;
    private String fechaPublicacion;

    public EntradaResponseFullDTO(Integer id, String tituloEntrada, String autor, String fechaPublicacion) {
        this.id = id;
        this.tituloEntrada = tituloEntrada;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
