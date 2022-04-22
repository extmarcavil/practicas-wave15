package com.example.blog.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
