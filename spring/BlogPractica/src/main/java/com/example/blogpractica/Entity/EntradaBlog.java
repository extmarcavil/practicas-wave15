package com.example.blogpractica.Entity;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntradaBlog {

    private Integer idBlog;
    private String títuloBlog;
    private String nombreAutor;
    private LocalDate fechaPublicacion;


}
