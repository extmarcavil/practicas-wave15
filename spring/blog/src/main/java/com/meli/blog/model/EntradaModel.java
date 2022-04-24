package com.meli.blog.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
public class EntradaModel {
    private Number id;
    private String tituloEntrada;
    private String autor;
    private String fechaPublicacion;

    public EntradaModel(Number id, String tituloEntrada, String autor, String fechaPublicacion) {
        this.id = id;
        this.tituloEntrada = tituloEntrada;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
