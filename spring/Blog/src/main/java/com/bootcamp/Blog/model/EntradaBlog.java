package com.bootcamp.Blog.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlog {
    private Integer id;
    private String titulo, autor;
    private LocalDate fecha_publicacion;

    public EntradaBlog(Integer id, String titulo, String autor, LocalDate fecha_publicacion) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_publicacion = fecha_publicacion;
    }

    public EntradaBlog(Integer id, String titulo, LocalDate fecha_publicacion) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_publicacion = fecha_publicacion;
    }

    public EntradaBlog() {
    }
}
