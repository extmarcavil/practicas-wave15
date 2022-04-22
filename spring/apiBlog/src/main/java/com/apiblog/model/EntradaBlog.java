package com.apiblog.model;

import java.util.Date;

public class EntradaBlog {
    public Integer id;

    public String  titulo;

    public  String nombreAutor;

    public Date fechaPublicacion;

    //region Constructor
    public EntradaBlog() {
    }

    public EntradaBlog(int id, String titulo, String nombreAutor, Date fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }
    //endregion

    //region getters setters

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    //endregion
}
