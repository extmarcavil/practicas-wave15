package com.youtuber.Blog.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;

    public EntradaBlog(Integer id, String titulo, String nombreAutor, LocalDate fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public EntradaBlog() {
    }
}
