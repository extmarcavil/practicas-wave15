package com.apiblog.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class EntradaBlogResponseDTO {

    private int id;

    private String  titulo;

    private  String nombreAutor;

    private Date fechaPublicacion;

    //region Constructor

    public EntradaBlogResponseDTO() {
    }

    public EntradaBlogResponseDTO(int id, String titulo, String nombreAutor, Date fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }
//endregion
}
