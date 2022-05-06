package com.bootcamp.youtuber.entities;


import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EntradaBlog {

    /**
     * Atributos
     */
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;


}
