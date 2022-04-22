package com.example.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class EntradaBlogDTO {
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
