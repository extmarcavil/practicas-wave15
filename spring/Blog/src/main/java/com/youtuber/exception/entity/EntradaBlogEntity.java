package com.youtuber.exception.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntradaBlogEntity {

    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;


    public EntradaBlogEntity(Integer id, String titulo, String autor, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
