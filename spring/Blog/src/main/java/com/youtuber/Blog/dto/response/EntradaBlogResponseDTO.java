package com.youtuber.Blog.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlogResponseDTO {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;

    public EntradaBlogResponseDTO(Integer id, String titulo, String nombreAutor, LocalDate fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public EntradaBlogResponseDTO() {
    }

    public boolean isNull() {
        if(id==null)
            return true;
        return false;
    }
}
