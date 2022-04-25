package com.bootcamp.Blog.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlogDTO {
    private Integer id;
    private String titulo;
    private LocalDate fecha_publicacion;

    public EntradaBlogDTO(Integer id, String titulo, LocalDate fecha_publicacion) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_publicacion = fecha_publicacion;
    }

    public EntradaBlogDTO() {
    }
}


