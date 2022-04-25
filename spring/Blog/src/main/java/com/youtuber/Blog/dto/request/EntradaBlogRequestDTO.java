package com.youtuber.Blog.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlogRequestDTO {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate fechaPublicacion;

    public EntradaBlogRequestDTO(Integer id, String titulo, String nombreAutor, LocalDate fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public EntradaBlogRequestDTO() {
    }
}
