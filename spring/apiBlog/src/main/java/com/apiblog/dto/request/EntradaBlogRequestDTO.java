package com.apiblog.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EntradaBlogRequestDTO {
    private int id;

    private String  titulo;

    private  String nombreAutor;

    private Date fechaPublicacion;

    //region constructor

    public EntradaBlogRequestDTO() {
    }

    public EntradaBlogRequestDTO(int id, String titulo, String nombreAutor, Date fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }
//endregion
}
