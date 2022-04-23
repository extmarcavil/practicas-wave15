package com.pacticaintegradora.blog.model;

import java.time.LocalDate;
import java.util.Date;

public class EntradaBlog {

    private Long   id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fecha;

    public EntradaBlog(Long id, String titulo, String nombreAutor, LocalDate fecha) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
