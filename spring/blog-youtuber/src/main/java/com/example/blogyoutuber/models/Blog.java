package com.example.blogyoutuber.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Blog {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
