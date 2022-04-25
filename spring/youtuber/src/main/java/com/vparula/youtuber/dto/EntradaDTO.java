package com.vparula.youtuber.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class EntradaDTO {
    int id;
    String titulo;
    String nombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date fecha;

    public EntradaDTO() {
    }

    public EntradaDTO(int id, String titulo, String nombre, Date fecha) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fecha = fecha;
    }
}
