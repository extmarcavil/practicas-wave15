package com.bootcamp.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String autor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicacion;
}
