package com.vparula.youtuber.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class EntradaBlog {
    int id;
    String titulo;
    String nombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date fecha;

    public EntradaBlog(int id, String titulo, String nombre, Date fecha) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public EntradaBlog() {
    }


    public int getId() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
